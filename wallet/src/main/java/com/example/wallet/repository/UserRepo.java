package com.example.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wallet.entity.Users;
public interface UserRepo extends JpaRepository<Users,Integer> {
Users findByUsername(String username);
	

}
