package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import Model.AuthInfoDTO;
import Model.EmployeeDTO;
import command.EmployeeCommand;
import repository.EmployeeRepository;

public class EmployeeModifyService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public void empUpdate1(HttpSession session , EmployeeCommand employeeCommand,Errors errors) {
	AuthInfoDTO authInfo=(AuthInfoDTO)session.getAttribute("authInfo");
	String empId=authInfo.getUserId();
	if(bcryptPasswordEncoder.matches(employeeCommand.getEmpPw(),authInfo.getUserPw())) {
		EmployeeDTO employeeDTO=new EmployeeDTO();
		employeeDTO.setJobId(employeeCommand.getJobId());
		employeeDTO.setPhNumber(employeeCommand.getPhNumber());
		employeeDTO.setOfficeNumber(employeeCommand.getOfficeNumber());
		employeeDTO.setEmail(employeeCommand.getEmail());
		employeeDTO.setEmpAddress(employeeCommand.getEmpAddress());
		employeeDTO.setEmpUserId(empId);
		employeeRepository.empUpdate1(employeeDTO);
	}else {
		errors.rejectValue("empPw", "notPw");
		}
		
		
	}
	
	
}
