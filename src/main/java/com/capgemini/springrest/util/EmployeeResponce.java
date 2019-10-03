package com.capgemini.springrest.util;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.capgemini.springrest.beans.EmployeeBean;
import com.fasterxml.jackson.annotation.JsonInclude;

@XmlRootElement(name= "employee-responce")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponce {
	
	@XmlElement(name="status-code")
	private int statusCode;
	@XmlElement
	private String message;
	@XmlElement
	private String description;
	@XmlElement
	private EmployeeBean employeeBean;
	@XmlElement
	private List<EmployeeBean> employeesList;
	
	// Getters and Setters
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	public List<EmployeeBean> getEmployeesList() {
		return employeesList;
	}
	public void setEmployeesList(List<EmployeeBean> employeesList) {
		this.employeesList = employeesList;
	}
	
}// end of class
