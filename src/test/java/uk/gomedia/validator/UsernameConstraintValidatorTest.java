package uk.gomedia.validator;

import static org.junit.Assert.*;
import java.util.Arrays;
import javax.validation.ConstraintValidatorContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import uk.gomedia.validator.UsernameConstraintValidator;


@RunWith(Parameterized.class)
public class UsernameConstraintValidatorTest {
	
	private String input;
    private boolean expected;
    ConstraintValidatorContext cvc = null;
	UsernameConstraintValidator usernameConstraintValidator = new UsernameConstraintValidator();
	
    
    public UsernameConstraintValidatorTest(String input, boolean expected){
    	this.input = input;
    	this.expected = expected;
    }
	
    
    @Parameters(name = "{index}: isValidTest({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 { "as as", false }, { "test", true },{"_asd_",false}, {" as ",false},
                 { "$%test", false}, { "qwertyui" , true } ,{"AdrianDudek1",true},
                 {"Adrian#Dudek1",false}, {"", false }
           });
    }
    
	@Test
	public void isValidTest(){
		assertEquals(expected,usernameConstraintValidator.isValid(input, cvc));
	}
}
