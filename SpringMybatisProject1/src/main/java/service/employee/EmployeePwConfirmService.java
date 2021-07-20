package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeePwConfirmService {
@Autowired
BCryptPasswordEncoder bcryptPasswordEncoder;
@Autowired
EmployeeRepository employeeRepository;
public String empPw(String empPw,HttpSession session,Model model) {
	AuthInfoDTO authInfo =
			(AuthInfoDTO)session.getAttribute("authInfo");
	EmployeeDTO dto =employeeRepository.empInfo(authInfo.getGrade());
	if(bcryptPasswordEncoder.matches(empPw, dto.getEmpPw())) {
		return"employee/emppwChangeOk";
	}else {
		model.addAttribute("pwFail1","비밀번호가 틀립니다");
		return"employee/emppwChang";
	}
}
}
