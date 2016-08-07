package uk.gomedia.validator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import uk.gomedia.validator.PasswordConstraintValidator;

@RunWith(Parameterized.class)
public class PasswordConstraintValidatorTest {
	private String input;
    private boolean expected;
    ConstraintValidatorContext cvc = null;
    PasswordConstraintValidator passwordConstraintValidator = new PasswordConstraintValidator();
	
    
    public PasswordConstraintValidatorTest(String input, boolean expected){
    	this.input = input;
    	this.expected = expected;
    }
	
    
    @Parameters(name = "{index}: isValidTest({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 { "qwer", false }, { "test1C", true }, {"C12cas", true}, {"1Ac", false},
                 { "qwer2", false }
           });
    }
    
	@Test
	public void isValidTest(){
		assertEquals(expected,passwordConstraintValidator.isValid(input, cvc));
	}
}
