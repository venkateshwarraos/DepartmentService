package com.dept.main.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dept.main.exception.DepartmentNotFoundException;
import com.dept.main.model.Department;
import com.dept.main.repository.DepartmentRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/departmentdetails")
public class DepartmentController {
	
	
	private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

	
	private static final  String exceptioMessage = "No record found for the requested data";
	
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@ApiOperation(value="view list of all department records, if its empty please insert a records through post method",response=List.class)
	@GetMapping(value="/departments")
	@ResponseBody
	public List<Department> getDepartments() throws SQLException,Exception  {		
		
		List<Department> department = null;			
		department = departmentRepo.findAll();		
		return department;		
				
	}
	
	
	
	@ApiOperation(value="find the department by the department number",response=Map.class)
	@GetMapping(value="/department/{id}")
	@ResponseBody
	public Map<String, Object> findDepartmentById(@PathVariable final String id) throws SQLException  {
		Optional<Department> department = null;
		Map<String, Object> departmentMap = null;
		
			 
			 department = departmentRepo.findById(Long.valueOf(id));
			 if(department.isPresent())  {
				 departmentMap = new HashMap<String, Object>();
				 departmentMap.put("departmentName", department.get().getDepartmentName());				 
				 departmentMap.put("departmentNumber", department.get().getDeptNo());			 
				 
			 } else {
				 
				 throw new DepartmentNotFoundException(DepartmentController.exceptioMessage);
			 }
			 
		
		return departmentMap;
	}
	
	@ApiOperation(value="insert department record",response=Department.class)
	@PostMapping(value="/department")
	@ResponseBody
	public  Department insertDepartment(@RequestBody Department department) throws SQLException   {
		Optional<Department> departmentMap = null;	
			
			departmentRepo.save(department);
			departmentMap =  departmentRepo.findById(department.getDeptNo());
			if(!departmentMap.isPresent())  {
				throw new DepartmentNotFoundException(DepartmentController.exceptioMessage.concat(department.getDepartmentName()));
			}
				
		return departmentMap.get();
	}
	
	@ApiOperation(value="update depart details",response=Department.class)
	@PutMapping(value="department")
	@ResponseBody
	public Department updateDepartmentInfo(@RequestBody final Department department) throws SQLException {
		
		Optional<Department> departmentInfo = null;		
			
			departmentInfo = departmentRepo.findByDepartmentName(department.getDepartmentName());
			if(departmentInfo.isPresent()) {
				departmentInfo.get().setDepartmentName(department.getDepartmentName());
				departmentInfo.get().setDeptLoc(department.getDeptLoc());
				departmentRepo.save(departmentInfo.get());
			} else {
				throw new DepartmentNotFoundException(DepartmentController.exceptioMessage.concat(department.getDepartmentName()));
			}
		 
		return departmentInfo.get();
	}
	
	@ApiOperation(value="Delete the department details",response=String.class)
	@DeleteMapping(value="/department/{id}")
	@ResponseBody
	public String deleteDepartmentRecord(@PathVariable final Long id) throws SQLException  {
		String response = null;
		Optional<Department> department =  null;
		
			department = departmentRepo.findById(id);
			if(department.isPresent()) {			
			departmentRepo.deleteById(id);	
			response = "department recode "+department.get().getDepartmentName()+" deleted";
			} else {
				throw  new DepartmentNotFoundException(DepartmentController.exceptioMessage);
			}
			
		 
		return response;
	}

}
