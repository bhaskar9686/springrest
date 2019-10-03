package com.capgemini.springrest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springrest.beans.EmployeeBean;
import com.capgemini.springrest.service.EmployeeService;
import com.capgemini.springrest.util.EmployeeResponce;

@RestController
public class EmpRestController {
	
	@Autowired
	private EmployeeService service = null;
	
	
	@GetMapping("/searchEmployee")
	public EmployeeResponce searchEmployee(int empId) {
		EmployeeResponce responce = new EmployeeResponce();
		EmployeeBean employeeBean = service.searchEmployee(empId);
		if(employeeBean!=null) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Employee Found Successfully");
			responce.setEmployeeBean(employeeBean);
		}else {
			responce.setStatusCode(401);
			responce.setMessage("Failed");
			responce.setDescription("Unable to fetch Employee");
		}
		return responce;
	}// end of searchEmployee()

	
	@PostMapping(path = "/addEmployee", 
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public EmployeeResponce addEmployee(@RequestBody EmployeeBean employeeBean) {
		EmployeeResponce responce = new EmployeeResponce();
		if(service.addEmployee(employeeBean)) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Employee Added Successfully");
		}else {
			responce.setStatusCode(401);
			responce.setMessage("Failed");
			responce.setDescription("Unable to Add Employee");
		}
		return responce;
	}// end of addEmployee()
	
	
	@PutMapping("/updateEmployee")
	public EmployeeResponce updateEmployee(EmployeeBean employeeBean) {
		EmployeeResponce responce = new EmployeeResponce();
		if(service.updateEmployee(employeeBean)) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Employee Updated Successfully");
		}else {
			responce.setStatusCode(401);
			responce.setMessage("Failed");
			responce.setDescription("Unable to update Employee");
		}
		return responce;
	}// end of updateEmployee()
	
	
	@DeleteMapping("/deleteEmployee/{empId}")
	public EmployeeResponce deleteEmployee(@PathVariable(name= "empId") int empId) {
		EmployeeResponce responce  = new EmployeeResponce();
				if(service.deleteEmployee(empId)) {
					responce.setStatusCode(201);
					responce.setMessage("Success");
					responce.setDescription("Employee Deleted Successfully");
				}else {
					responce.setStatusCode(401);
					responce.setMessage("Failed");
					responce.setDescription("Unable to Find Employee");
				}
				return responce;
	}// end of deleteEmployee()
	
	
	@GetMapping(path= "/getAllEmployee",
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public EmployeeResponce getAllEmployee() {
		List<EmployeeBean> employeesList = service.getEmployee();
		EmployeeResponce responce = new EmployeeResponce();
		if(employeesList!=null) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Employee Fetched  Successfully");
			responce.setEmployeesList(employeesList);
		}else {
			responce.setStatusCode(401);
			responce.setMessage("Failed");
			responce.setDescription("Unable to fetch Employee");
		}
		return responce;
	}// end of getAllEmployee()
	
}// end of Controller
