package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeInfoService1 {
	@Autowired
	EmployeeRepository employeeRepository;
	public void empInfo(HttpSession session, Model model) {
		AuthInfoDTO authInfo = 
				(AuthInfoDTO)session.getAttribute("authInfo");
		String empId = authInfo.getGrade();
		EmployeeDTO dto = employeeRepository.empInfo(empId);
		model.addAttribute("employeeCommand", dto);
		
		
		
		
	}
}
