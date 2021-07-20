package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import Model.AuthInfoDTO;
import Model.EmployeeDTO;
import command.EmployeeCommand;
import repository.EmployeeRepository;

public class EmployeePwUpdateService {
@Autowired
BCryptPasswordEncoder bcryptPasswordEncoder;
@Autowired
EmployeeRepository employeeRepository;	

public void empPwUpdate(EmployeeCommand employeeCommand,Errors errors,HttpSession session) {
	AuthInfoDTO authInfo=(AuthInfoDTO)session.getAttribute("authInfo");
	EmployeeDTO emp = employeeRepository.empInfo(authInfo.getGrade());
	if(bcryptPasswordEncoder.matches(employeeCommand.getEmpoldPw(),emp.getEmpPw() )) {
	EmployeeDTO dto=new EmployeeDTO();
	dto.setEmpUserId(authInfo.getUserId());
	dto.setEmpPw(bcryptPasswordEncoder.encode(employeeCommand.getEmpPw()));
	employeeRepository.empPwUpdate(dto);
	}else {
		errors.reject("empoldPw","notPw");
	}
	
}
}
