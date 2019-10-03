package com.capgemini.springrest.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name="emp_info")
@XmlRootElement(name="emp-info")// to view in the form of xml
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("employeeInfo")// to view in the form of jsn
@JsonPropertyOrder({"employeeId","employeeName"})
@JsonInclude(JsonInclude.Include.NON_NULL)// ignore if any null value
public class EmployeeBean {

	@Id
	@Column(name="emp_id")
	@XmlElement(name="emp-id")// to view in the form of xml
	@JsonProperty("employeeId")// to view in the form of json
	private int empId;
	
	@Column(name="emp_name")
	@XmlElement(name="emp-name")
	@JsonProperty("employeeName")
	private String empName;
	
	@XmlElement
	private int age;
	
	@XmlElement
	private double salary;
	
	@XmlElement
	private String position;

	@XmlElement
	private String password;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
