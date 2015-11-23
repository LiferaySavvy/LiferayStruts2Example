package com.meera.struts2.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.meera.service.model.Student;
import com.meera.service.service.StudentLocalServiceUtil;
import com.meera.struts2.MessageStore;
import com.meera.struts2.validator.StudentValidator;
import com.opensymphony.xwork2.Preparable;
public class EditStudentAction extends DefaultActionSupport 
								implements Preparable, ParameterAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1672869159642951666L;
	
	private long oldName;
	private String name;
	private String place;
	private String state;
	private Student student; 
	private Map<String, String[]> parameters;
	private MessageStore messageStore;
	private Map<String, Object> session;
	
   	@Override
   	public String execute() throws Exception {
   		System.out.println("==========in execute =="+getStudent());
		ArrayList<String> errors = new ArrayList<String>();
		StudentValidator validator = new StudentValidator();
		StringBuilder message = new StringBuilder();
		messageStore = new MessageStore() ;
		//assign new values to the bookmark
		getStudent().setStudentName(getName());
		getStudent().setStudentPlece(getPlace());
		getStudent().setStudentState(getState());
		System.out.println("==========in execute =="+getStudent());
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
   	public String getStudentObject(){
   		return "success";
   	}
	@Override
	public void prepare() throws Exception {
		
		System.out.println("==========in prepare ==");
		// Since the prepare interceptor is run before the parameter interceptor,    		
		// we have to get the parameter "manually".   		
		this.oldName =Long.valueOf(parameters.get("oldName")[0]);   		
		setStudent(retrieveStudent());
		System.out.println("==========in prepare =="+parameters.get("oldName")[0]);
		//put bookmark in session
		getSession().put("student1",getStudent());
		System.out.println("==========in getSession() =="+getSession());
	}
   
   	/**
	 * find the Bookmark Object from the view with the old bookmark name
	 * @return 
   	 * @throws PortalException 
	 */
	private Student retrieveStudent() throws PortalException {
		Student students = null;
		
		try {
			
			students = StudentLocalServiceUtil.getStudent(getOldName());
			System.out.println("retrieveStudent"+students);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
	
			
		return students;
	}
	

	/*
	 * Getters and Setters start here
	 */
   	public long getOldName() {
   		return oldName;
   	}
	
   	public void setOldName(long oldName) {
   		this.oldName = oldName;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	
	public void setParameters(Map<String, String[]> parameters) {   		
		this.parameters = parameters;   	
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

	public Map<String, Object> getSession() {  
		return session;  
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
   	
}