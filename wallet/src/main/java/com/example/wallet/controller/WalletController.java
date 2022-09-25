package com.example.wallet.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.wallet.entity.Users;
import com.example.wallet.service.MyUserDetailsService;

@RestController
public class WalletController {
	@Autowired
	MyUserDetailsService service;
	String uname;
	@RequestMapping("/")
	public ModelAndView welcome(Principal principal) {
	uname=principal.getName();
	Users user1=service.findByUsername(uname);
	ModelAndView mv =new ModelAndView("home.jsp");
	mv.addObject("client1",user1);
		return mv;
	}
	
	 
	@RequestMapping("/addBalance")
	public ModelAndView addBalance(){
		
		ModelAndView mv=new ModelAndView("addBalance.jsp");
		Users user=service.findByUsername(uname);
		mv.addObject("client", user);
		return mv;
		
	}
	@RequestMapping("/newBalance")
	public ModelAndView newBalance(@RequestParam("amount")int amount) {
		service.addMoney(amount,uname);
		ModelAndView mv =new ModelAndView("addBalance.jsp");
		Users user=service.findByUsername(uname);
		mv.addObject("client", user);
		
		return mv;
		
	}
	@RequestMapping("/withDraw")
	public ModelAndView withDraw(){
		ModelAndView mv=new ModelAndView("withdraw.jsp");
		Users user=service.findByUsername(uname);
		mv.addObject("client", user);
		return mv;
		
		
	}
	@RequestMapping("/withDrawMoney")
	public ModelAndView withDrawMoney(@RequestParam("amount") int amount)throws Exception{
		ModelAndView mv=new ModelAndView("withdraw.jsp");
		ModelAndView mv1=new ModelAndView("withdrawerr.jsp");
		if(service.drawMoney(uname, amount)) {
			mv.addObject("client", service.findByUsername(uname));
			return mv;
		}
		else {
			
			return mv1;
		}
		
		
		
		
		
		
	}
	  
	
	 

}
