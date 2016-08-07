package uk.gomedia.rest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import com.google.gson.JsonObject;
import uk.gomedia.RegistrationAppApplication;
import java.nio.charset.Charset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=RegistrationAppApplication.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRestControllerTest {

	private MockMvc mockMvc;

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
	            MediaType.APPLICATION_JSON.getSubtype(),
	            Charset.forName("utf8"));
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	@Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }
	
	
	@Test
	public void testRegister1() throws Exception {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("username", "adrian");
		jsonObject.addProperty("password", "Abc12as");
		jsonObject.addProperty("dateOfBirth", "1985-06-12");
		jsonObject.addProperty("email", "ado.adrian@gmail.com");
		String requestJson = jsonObject.toString();
	    mockMvc.perform(post("/register/")
		   			.contentType(contentType)
		   			.content(requestJson) )
	    		.andExpect(status().isOk());
	}
	    
	@Test
	public void testRegister2() throws Exception {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("username", "adrian");
		jsonObject.addProperty("password", "Abc12as");
		jsonObject.addProperty("dateOfBirth", "1985-06-12");
		jsonObject.addProperty("email", "ado.adrian@gmail.com");
		String requestJson = jsonObject.toString();
	    mockMvc.perform(post("/register/")
		   			.contentType(contentType)
		   			.content(requestJson) )
	    		.andExpect(status().is(422));
	
	}
	
	
	@Test
	public void testRegister3() throws Exception {
		mockMvc.perform(get("/users").contentType(contentType)).andExpect(status().isOk());
	}		

}
