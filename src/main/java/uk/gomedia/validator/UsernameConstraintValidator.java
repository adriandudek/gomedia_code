package uk.gomedia.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;



public class UsernameConstraintValidator implements ConstraintValidator<Username, String> {

	@Override
	public void initialize(Username username) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext cvc) {
		if(username == null){
			return false;
		}
		return StringUtils.isAlphanumeric(username);
	} 
}
