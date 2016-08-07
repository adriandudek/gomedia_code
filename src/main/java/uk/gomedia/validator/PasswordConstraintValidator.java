package uk.gomedia.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;



public class PasswordConstraintValidator  implements ConstraintValidator<Password, String> {

	@Override
	public void initialize(Password constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		if(password == null){
			return false;
		}
		if(password.length() < 6){
			return false;
		}
		char[] numChar = {'0','1','2','3','4','5','6','7','8','9'};
		if(StringUtils.containsAny(password, numChar)){
			String passwordLowerCase = password.toLowerCase();
			String passwordUpperCase = password.toUpperCase();
			return !password.equals(passwordLowerCase) && !password.equals(passwordUpperCase);
			
		}else{
			return false;
		}
	}
	
	

}
