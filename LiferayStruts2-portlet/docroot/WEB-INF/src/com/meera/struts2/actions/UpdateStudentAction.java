package com.meera.struts2.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.meera.service.model.Student;
import com.meera.service.model.impl.StudentImpl;
import com.meera.service.service.StudentLocalServiceUtil;
import com.meera.struts2.MessageStore;
import com.meera.struts2.validator.StudentValidator;
public class UpdateStudentAction extends DefaultActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4587665276501838677L;
	
	private long id;
	private String name;
	private String place;
	private String state;
	private Student student; 
	private MessageStore messageStore;
   	@Override
   	public String execute() throws Exception {
   		System.out.println("==========in execute =="+getStudent());
		ArrayList<String> errors = new ArrayList<String>();
		StudentValidator validator = new StudentValidator();
		StringBuilder message = new StringBuilder();
		messageStore = new MessageStore() ;
		//assign new values to the bookmark
		student= new StudentImpl();
		student.setStudentId(getId());
		student.setStudentName(getName());
		student.setStudentPlece(getPlace());
		student.setStudentState(getState());
		System.out.println("==========in execute =="+student);
		if(validator.validateStudent(student, errors)) {
			//update the Bookmark in the database
			StudentLocalServiceUtil.updateStudent(student);
			//create success message
			message.append("Bookmark ").append(getName())
				.append(" has been updated successfully.");
			messageStore.setMessage(message.toString());
			
			//add success added message
			addActionMessage(messageStore.getMessage());
			
			return SUCCESS;
		}
		else {
			//handle error message
			message.append("Bookmark ").append(getName())
				.append("was not updated!");
			messageStore.setMessage(message.toString());
			
//			addActionError(messageStore.getMessage());
			addFieldError("failed", messageStore.getMessage());
			Iterator<String> errorIter = errors.iterator();
			int count = 0;
			while (errorIter.hasNext()) {
				String error = errorIter.next();
				addFieldError("error" + count, error);
				count++;
			}
			
			return ERROR;
		}
   	}
   	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudentObject(){
   		return "success";
   	}
	
   
   	/**
	 * find the Bookmark Object from the view with the old bookmark name
	 * @return 
   	 * @throws PortalException 
	 */
	


	/*
	 * Getters and Setters start here
	 */
	
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MessageStore getMessageStore() {
		return messageStore;
	}

	public void setMessageStore(MessageStore messageStore) {
		this.messageStore = messageStore;
	}



	
}