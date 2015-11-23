package com.meera.struts2;

/**
 * Model class that stores a message.
 * @author Fuping Ma
 *
 */
public class MessageStore {
	
	public static String STUDENT_ADDED_SUCCESSFUL = "Student has been added successfully.";
	public static String BOOKMARK_ADDED_FAILED = "Student was not added!";
	public static String BOOKMARK_REMOVED_SUCCESSFUL = "The Student has been deleted.";
	public static String BOOKMARK_REMOVED_FAILED = "The Student was not deleted!";
	public static String BOOKMARK_RETRIEVE_FAILED = "Could not retrieve Student from the database.";
	
	private String message;
	
	public MessageStore() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}