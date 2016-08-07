package uk.gomedia.validator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import uk.gomedia.validator.DateIsoFormatConstraintValidator;

@RunWith(Parameterized.class)
public class DateIsoFormatConstraintValidatorTest {
	private String input;
    private boolean expected;
    ConstraintValidatorContext cvc = null;
    DateIsoFormatConstraintValidator dateIsoFormatConstraintValidator = new DateIsoFormatConstraintValidator();
	
    
    public DateIsoFormatConstraintValidatorTest(String input, boolean expected){
    	this.input = input;
    	this.expected = expected;
    }
	
    
    @Parameters(name = "{index}: isValidTest({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 { "1900-02-01", true }, { "-1900-02-01", false }, {"", false}, 
                 {"1Ac", false}, { "2015-08-07T12:17:54Z", true }
           });
    }
    
	@Test
	public void isValidTest(){
		assertEquals(expected,dateIsoFormatConstraintValidator.isValid(input, cvc));
	}
}
