package com.capgemini.springrest.dao;

import java.util.List;

import com.capgemini.springrest.beans.EmployeeBean;


public interface EmployeeDAO {

	public EmployeeBean login(int empId, String passwod);
	public boolean addEmployee(EmployeeBean employeeBean);
	public EmployeeBean searchEmployee(int empId);
	public boolean deleteEmployee(int empId);
	public boolean updateEmployee(EmployeeBean employeeBean);
	public List<EmployeeBean> getEmployee();
}
