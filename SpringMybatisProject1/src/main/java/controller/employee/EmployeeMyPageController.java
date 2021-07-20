package controller.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.EmployeeCommand;
import service.employee.EmployeeInfoService1;
import service.employee.EmployeeModifyService;
import service.employee.EmployeeOutService;
import service.employee.EmployeePwConfirmService;
import service.employee.EmployeePwUpdateService;
import validator.EmployeePasswordValidator;

@Controller
@RequestMapping("emedit")
public class EmployeeMyPageController {
	
	@Autowired
	EmployeeInfoService1 employeeInfoService1;
	@Autowired
	EmployeeModifyService employeeModifyService;
	@Autowired
	EmployeePwConfirmService employeePwConfirmService;
	@Autowired
	EmployeePwUpdateService employeePwUpdateService;
	@Autowired
	EmployeeOutService employeeOutService;
	@RequestMapping("empOut")
	public String empOut() {
			return "employee/empOut";
	}
	@RequestMapping("empOutOk")
	public String empOutOk(
			@RequestParam(value="empPw")String empPw,
			HttpSession session,Model model) {
		String path=employeeOutService.empDelete(empPw, session, model);
		return path;
	}
	
	@RequestMapping("myPage")
	public String myPage(){
		return "employee/empMyPage";
	}
	@RequestMapping("empDetail")
	public String empDetail(HttpSession session, Model model) {
		employeeInfoService1.empInfo( session,  model);
		return"employee/employeeDetail"; 
	}
	@RequestMapping("empSujung")
	public String empSujung(HttpSession session,Model model, @ModelAttribute  EmployeeCommand employeeCommand) {
		employeeInfoService1.empInfo( session,  model);
		return "employee/empSujung";
	}
	
	@RequestMapping(value="empSujungOk",method=RequestMethod.POST)
	public String empUpdate1(HttpSession session , EmployeeCommand employeeCommand,Errors errors) {
		employeeModifyService.empUpdate1(session, employeeCommand, errors);
		if(errors.hasErrors()){
			return "employee/empSujung";
		}
		//리턴은 주소를 찍어줘야함 !!
		return "redirect:empDetail";
	}
	@RequestMapping("empPwChange")
	public String empPwChange() {
		return"employee/emppwChang";
	}
	@RequestMapping("emppwChangeOk")
		public String emppwChangOk(
				@RequestParam(value="empPw")String empPw,HttpSession session ,Model model,
				@ModelAttribute EmployeeCommand employeeCommand) {
				String path=employeePwConfirmService.empPw(empPw, session, model);
				return path;
			
	}
	@RequestMapping("empChangePw")
	public String empChangePw(EmployeeCommand employeeCommand,
			Errors errors,HttpSession session) {
		new EmployeePasswordValidator().validate(employeeCommand, errors);
		if(errors.hasErrors()) {
			return"employee/emppwChangeOk";
		}
		employeePwUpdateService.empPwUpdate(employeeCommand,errors,session);
		if(errors.hasErrors()) {
			return"employee/emppwChangeOk";
		}
		return "redirect:/";
	}
		
}


