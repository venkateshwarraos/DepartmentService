package com.dept.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Department {
	
	@Id
	@GeneratedValue
	private Long deptNo;
	@NotNull
	private String departmentName;
	private String deptLoc;
	
	public Long getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Long deptNo) {
		this.deptNo = deptNo;
	}
	public Department(Long deptNo, @NotNull String departmentName, String deptLoc) {
		super();
		this.deptNo = deptNo;
		this.departmentName = departmentName;
		this.deptLoc = deptLoc;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDeptLoc() {
		return deptLoc;
	}
	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}
	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", departmentName=" + departmentName + ", deptLoc=" + deptLoc + "]";
	}
	public Department() {
		
	}
	
	
	
	

}
