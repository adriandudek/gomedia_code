package uk.gomedia.validator;

import java.text.ParseException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

public class DateIsoFormatConstraintValidator implements ConstraintValidator<DateIsoFormat, String>{

	@Override
	public void initialize(DateIsoFormat constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String dateIsoFormat, ConstraintValidatorContext context) {
		if(dateIsoFormat == null){
			return false;
		}
		if(dateIsoFormat.isEmpty()){
			return false;
		}
		
		ISO8601DateFormat df = new ISO8601DateFormat();
		try {
			df.parse(dateIsoFormat);
		} catch (ParseException e) {
			//e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
