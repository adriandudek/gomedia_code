package uk.gomedia.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO {
	private List<FieldErrorDTO> fieldErrors = new ArrayList<>();
	 
    public ValidationErrorDTO() {
 
    }
 
    public void addFieldError(String path, String message) {
        fieldErrors.add(new FieldErrorDTO(path, message));
    }
    
    public List<FieldErrorDTO> getFieldErrors() {
        return fieldErrors;
    }
}
