package com.meera.struts2.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.meera.service.model.Student;
import com.meera.service.model.impl.StudentImpl;
import com.meera.service.service.StudentLocalServiceUtil;
import com.meera.struts2.MessageStore;
import com.meera.struts2.validator.StudentValidator;
public class AddStudentAction extends DefaultActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4587665276501838677L;
	
	private String name;
	private String place;
	private String state;
	
	private List<String> validateErrors;

	@Override
	public String execute() throws Exception {
		validateBookmark();
		
		if(validateErrors.size() > 0)
			return ERROR;
		else
			return SUCCESS;
	}
	
	public void validateBookmark() throws Exception {
		Student studentObject = getNewStudent();
		validateErrors = new ArrayList<String>();
		StudentValidator validator = new StudentValidator();
		
		if(validator.validateStudent(studentObject, validateErrors)) {
			StudentLocalServiceUtil.addStudent(studentObject);
			addActionMessage(MessageStore.STUDENT_ADDED_SUCCESSFUL);
			
		}
		else {
			//handle the error massage 
		addActionError(MessageStore.BOOKMARK_ADDED_FAILED);
			addFieldError("failed", MessageStore.BOOKMARK_ADDED_FAILED);
			Iterator<String> errorIter = validateErrors.iterator();
			int count = 0;
			while (errorIter.hasNext()) {
				String error = errorIter.next();
				addFieldError("error" + count, error);
				count++;
			}
		}
	}
	
	/**
	 * Create a new Bookmark Object from the view
	 * @return 
	 * @throws SystemException 
	 */
	private Student getNewStudent() throws SystemException {
		Student newStudent =  new StudentImpl();
		long id=CounterLocalServiceUtil.increment(Student.class.getName());
		newStudent.setStudentId(id);
		newStudent.setStudentName(getName());
		newStudent.setStudentPlece(getPlace());
		newStudent.setStudentState(getState());
		
		return newStudent;
	}

	/*
	 * Getters and Setters start here
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getValidateErrors() {
		return validateErrors;
	}

	public void setValidateErrors(List<String> validateErrors) {
		this.validateErrors = validateErrors;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}