package com.employ.process.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employ.app.entity.LogIn;


@Repository
public interface LoginRepo extends JpaRepository<LogIn, String> {

	
	@Query(value = "SELECT COUNT(*) FROM LogIn login WHERE userId = :userId AND password = :password")
	public int logIn(String userId, String password);
	
	@Query(value = "SELECT login FROM LogIn login WHERE userId = :userId ")
	public LogIn LoginDetails(@Param("userId") String userId);
	
}
