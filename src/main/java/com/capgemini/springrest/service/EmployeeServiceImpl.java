package com.capgemini.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springrest.beans.EmployeeBean;
import com.capgemini.springrest.dao.EmployeeDAO;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public EmployeeBean login(int empId, String passwod) {
		return dao.login(empId, passwod);
	}

	@Override
	public boolean addEmployee(EmployeeBean employeeBean) {
		return dao.addEmployee(employeeBean);
	}

	@Override
	public EmployeeBean searchEmployee(int empId) {
		EmployeeBean employeeBean = dao.searchEmployee(empId);
		employeeBean.setPassword(" ");
		return employeeBean;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		return dao.deleteEmployee(empId);
	}

	@Override
	public boolean updateEmployee(EmployeeBean employeeBean) {
		return dao.updateEmployee(employeeBean);
	}

	@Override
	public List<EmployeeBean> getEmployee() {
		return dao.getEmployee();
	}

}
