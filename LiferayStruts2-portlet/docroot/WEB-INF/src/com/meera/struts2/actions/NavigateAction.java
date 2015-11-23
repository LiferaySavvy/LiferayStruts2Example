package com.meera.struts2.actions;


import org.apache.struts2.dispatcher.DefaultActionSupport;

public class NavigateAction extends DefaultActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4587665276501838677L;
	@Override
	public String execute() throws Exception {
		String success="success";
			return success;
	}
	
	public String navigateToAddStudentJsp() throws Exception {
		String success="addstudent";
			return success;
	}
	public String navigateToShowStudentsJsp() throws Exception {
		String success="showstudents";
			return success;
	}
	public String navigateToManageStudentsJsp() throws Exception {
		String success="managestudents";
			return success;
	}
	
}