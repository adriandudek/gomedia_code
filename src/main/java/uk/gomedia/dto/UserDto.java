package uk.gomedia.dto;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import uk.gomedia.validator.DateIsoFormat;
import uk.gomedia.validator.Password;
import uk.gomedia.validator.Username;

public class UserDto {
	
	@Username(message="Incorrect Username value")
	String username;
	
	@Password(message="Incorrect Password value")
	String password;
		
	@DateIsoFormat(message="Incorrect Date value")
	String dateOfBirth;
	
	@NotNull
	@Email(message="Incorrect Email value")
	String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	/*
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	 */

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
