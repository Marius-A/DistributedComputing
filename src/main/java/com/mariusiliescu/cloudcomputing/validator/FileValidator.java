package com.mariusiliescu.cloudcomputing.validator;

import com.mariusiliescu.cloudcomputing.model.File;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class FileValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		return File.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		File file = (File) obj;

		if(file != null){
			errors.rejectValue("file", "valid.file");
		}
		if(file.getFile()!=null){
			if (file.getFile().getSize() == 0) {
				errors.rejectValue("fileUp", "valid.file");
			}
		}
	}
}