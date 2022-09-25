package com.example.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.wallet.service.PrincipalUser;
import com.example.wallet.entity.Users;
import com.example.wallet.repository.UserRepo;
@Component
public class MyUserDetailsService  implements UserDetailsService{
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=repo.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("404 no such user");
		}
		return new PrincipalUser(user);
	}

	public Users findByUsername(String uname) {
		return repo.findByUsername(uname);
	}

	public void addMoney(int amount, String name) {
		Users user=repo.findByUsername(name);
		long sum=0;
		sum=amount+user.getBalance();
		user.setBalance(sum);
		repo.save(user);
		
	}

	public Boolean drawMoney(String uname, int amount) {
		Users user=repo.findByUsername(uname);
		long sum=0;
		if(amount>user.getBalance()) {
			return false;
		}
		else {
			sum=user.getBalance()-amount;
			user.setBalance(sum);
			repo.save(user);
			return true;
		}
		
	}
	
	

}
