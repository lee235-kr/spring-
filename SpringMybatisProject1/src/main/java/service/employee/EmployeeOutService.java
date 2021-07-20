package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import repository.EmployeeRepository;

public class EmployeeOutService {
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	EmployeeRepository employeeRepository;
	public String empDelete(String empPw,HttpSession session
			,Model model) {
		AuthInfoDTO authInfo =
				(AuthInfoDTO)session.getAttribute("authInfo");
		System.out.println(authInfo.getUserId());
	if(bcryptPasswordEncoder.matches(empPw, authInfo.getUserPw())) {
		employeeRepository.empDel(authInfo.getUserId());
		return "redirect:/login/logOut";
	}else {
		model.addAttribute("epwFail","비밀번호다 다르다멍!");
		return "employee/empOut";
	 }
	}
}
