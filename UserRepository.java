package com.reglog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.reglog.model.User;
import java.util.List;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public boolean existsByEmail(String email);
	
	
}
