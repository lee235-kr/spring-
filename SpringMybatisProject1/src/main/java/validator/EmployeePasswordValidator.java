package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.EmployeeCommand;

public class EmployeePasswordValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object target, Errors errors) {
		EmployeeCommand empPP =(EmployeeCommand) target;
		ValidationUtils.rejectIfEmpty(errors, "empoldPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "empPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "empPwCon", "required");
		if(!empPP.getEmpPw().isEmpty()) {
			if(!empPP.isEmpPwEqualsEmpPwCon()) {
				errors.rejectValue("empPwCon", "nomatch");
			}
		}
	}

}
