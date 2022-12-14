package com.example.wallet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
	@Id
	private int id;
	private String username;
   private String password;
   private long balance;
public Users() {
	super();
	
}
public Users(int id, String username, String password, long balance) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.balance = balance;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public long getBalance() {
	return balance;
}
public void setBalance(long balance) {
	this.balance = balance;
}
@Override
public String toString() {
	return "Users [id=" + id + ", username=" + username + ", password=" + password + ", balance=" + balance + "]";
}

   
  
}
