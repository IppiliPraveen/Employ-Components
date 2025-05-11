package com.employ.process.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employ.app.entity.Employ;
import com.employ.process.app.repository.EmployRepo;

@Service
public class EmployService {
	
	@Autowired
	private EmployRepo employRepo;
	
	public List<Employ> getActiveEmploy() {

		List<Employ> employList = new ArrayList<>();
		employList=employRepo.getActiveEmploy();
		//employRepo.findAll().forEach(todo -> employList.add(todo));

		return employList;
	}

	public List<Employ> findEmployById(String empNo) {
		List<Employ> empList= employRepo.findByEmpId(empNo);
		return empList;
	}

	public String genarateEmpID() {

		int totalEmpNo=employRepo.genarateEmpID()+1;

		if (totalEmpNo < 10) {
	        return "EHYD00" + totalEmpNo;
	    } else if (totalEmpNo < 100) {
	        return "EHYD0" + totalEmpNo;
	    } else if (totalEmpNo < 1000) {
	        return "EHYD" + totalEmpNo;
	    }
	    return "";
	}

	public void save(Employ employ) {
		
		employRepo.save(employ);
	}

	public List<Employ> searchEmploy(String empNo) {//Employ or  List<Employ>
		
		List<Employ> employList=employRepo.findByEmpId(empNo);
//		Employ employ=employRepo.findByEmpNo(empNo).get(0);
//		LOG.info("62 -> "+employ.getName());
//		employ=employRepo.getByEmpNo(empNo);
//		LOG.info("64 ->"+employ.getName());
		return employList;
	}

	public void updateEmploy(Employ employ) {
		// TODO Auto-generated method stub
		this.save(employ);
		
	}

	public List<Employ> getAllEmployes() {
		// TODO Auto-generated method stub
		List<Employ> employList = new ArrayList<>();
		employList=employRepo.findAll();
		return employList;
	}
	
	//Search Employ by Employ Id 
	public Employ getEmploy(String empId) {
		
		Employ emp = employRepo.getByEmpId(empId);
		return emp;
	}


}
