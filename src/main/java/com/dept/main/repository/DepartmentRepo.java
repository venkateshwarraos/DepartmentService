package com.dept.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.dept.main.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

	Optional<Department> findByDepartmentName(String name);



}
