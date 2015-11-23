package com.meera.struts2.actions;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.meera.service.model.Student;
import com.meera.service.service.StudentLocalServiceUtil;
import com.opensymphony.xwork2.Action;
public class StudentJsonTable {

	//Your result List  
	private List<Student>      gridModel;  
	//get how many rows we want to have into the grid - rowNum attribute in the grid  
	private Integer             rows             = 0;  
	//Get the requested page. By default grid sets this to 1.  
	private Integer             page             = 0;  
	// sorting order - asc or desc  
	private String              sord;  
	// get index row - i.e. user click to sort.  
	private String              sidx;  
	// Search Field  
	private String              searchField;  
	// The Search String  
	private String              searchString;  
	// he Search Operation ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']  
	private String              searchOper;  
	// Your Total Pages  
	private Integer             total            = 0;  
	// All Record  
	private Integer             records          = 0;
	
	public String getStudentTable() {    
		int to = (rows * page);    
		int from = to - rows;    
		  
		try {
			//Count Rows (select count(*) from bookmark)  
			records = StudentLocalServiceUtil.getStudentsCount();
			//Your logic to search and select the required data.    
			gridModel = StudentLocalServiceUtil.getStudents(from, to);  
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		//calculate the total pages for the query    
		total =(int) Math.ceil((double)records / (double)rows); 
		
		return Action.SUCCESS;  
	}

	/*
	 * Getters and Setters start here
	 */
	public List<Student> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<Student> gridModel) {
		this.gridModel = gridModel;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}
}
