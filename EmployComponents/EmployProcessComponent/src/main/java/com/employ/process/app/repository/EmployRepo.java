package com.employ.process.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employ.app.entity.Employ;

@Repository
public interface EmployRepo extends JpaRepository<Employ, String>{
	
	public List<Employ> findByEmpId(String empId);
	
	@Query(value="SELECT COUNT(employ.empId) FROM Employ employ")
	public int genarateEmpID();

	public Employ getByEmpId(String empId);
	
	@Query(value="SELECT employ FROM Employ employ where employ.status='A'")
	public List<Employ> getActiveEmploy();


}