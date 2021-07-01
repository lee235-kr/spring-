package controller.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.EmployeeCommand;
import service.employee.EmployeeJoinService;
import service.employee.EmployeeNumService;
import validator.EmployeeCommandValidator;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	EmployeeNumService employeeNumService;
	@Autowired
	EmployeeJoinService employeeJoinService;
	@RequestMapping(value = "empList", method = RequestMethod.GET)
	public String empList() {
		return "employee/employeeList";
	}
	@RequestMapping(value= "empRegist",method = RequestMethod.GET	)
	public String empRegist(Model model , EmployeeCommand employeeCommand) {
		employeeNumService.empNo(model,employeeCommand);
		return "employee/employeeForm";
	}
	@RequestMapping(value = "empJoin",method = RequestMethod.POST)
	public String empJoin(EmployeeCommand employeeCommand,Errors errors,Model model) {
		//command 객체는 html로 부터 넘어온 값을 저장한다
		//그러므로 @requestparam으로 받아올 필요 없당
		System.out.println("empJoin"+employeeCommand.getEmpName());
		System.out.println("empJoin:" + employeeCommand.getEmpName());
		new EmployeeCommandValidator().validate(employeeCommand,errors);
		if(errors.hasErrors()) {
			return "employee/employeeForm";
			
		}
		employeeJoinService.empInsert(employeeCommand);
		return "redirect:empList" ;
			
	}
}