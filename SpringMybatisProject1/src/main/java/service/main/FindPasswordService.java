package service.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import Model.MemberDTO;
import command.MemberCommand;
import controller.MailService;
import controller.RamdomPassword;
import repository.MemberRepository;

public class FindPasswordService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	MailService mailService;
	public String findPassword(MemberCommand memberCommand,Model model) {

		MemberDTO dto=memberRepository.memInfo(memberCommand.getMemId());
		if(dto != null) {
			if(memberCommand.getMemEmail().equals(dto.getMemEmail())) {
				String pass=RamdomPassword.getRamdomPassword(10);
				String encodePass =bcryptPasswordEncoder.encode(pass);
				dto.setMemPw(encodePass);
				memberRepository.memPwUpdate(dto);
			
			System.out.println(pass);	
				return "main/passView";
			}else {
				model.addAttribute("errEmail", "이멜이 틀린디야??");
				return "main/findPassword";
			}
		}else {
			model.addAttribute("errMemId", "아디가 없는디야 ??");
			return "main/findPassword";
		}
		
	}
}
