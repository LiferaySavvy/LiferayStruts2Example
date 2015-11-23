package com.meera.struts2.validator;

import java.util.ArrayList;
import java.util.List;
import com.liferay.portal.kernel.util.Validator;
import com.meera.service.model.Student;
public class StudentValidator {
	/**
	 * Verify bookmark
	 * 
	 * @param bookmark
	 *            to be validated
	 * @param errors
	 *            to populate with any errors
	 */
	List<String> validateErrors = new ArrayList<String>();
	public boolean validateStudent(Student student, List<String> errors) {
		//validate name
		errors.addAll(validateStudentName(student.getStudentName()));
		errors.addAll(validateStudentPlace(student.getStudentPlece()));
		errors.addAll(validateStudentState(student.getStudentState()));
		
		/*
		 * com.liferay.portal.kernel.util.Validator has lots of utilities
		 * isNull,
		 * isEmailAddress,
		 * isPhoneNumber,
		 * ...
		 */
		//check url

		return errors.size() < 1;
	}
	
	public List<String> validateStudentName(String name) {
		List<String> validateErrors1 = new ArrayList<String>();
		
		if (Validator.isNull(name)) {
			validateErrors1.add("Student name is required.");
		}
		return validateErrors1;
	}
	public List<String> validateStudentPlace(String place) {
		List<String> validateErrors2 = new ArrayList<String>();
		
		if (Validator.isNull(place)) {
			validateErrors2.add("Student place is required.");
		}
		return validateErrors2;
	}
	public List<String> validateStudentState(String state) {
		List<String> validateErrors3 = new ArrayList<String>();
		
		if (Validator.isNull(state)) {
			validateErrors3.add("Student state is required.");
		}
		return validateErrors3;
	}
}
