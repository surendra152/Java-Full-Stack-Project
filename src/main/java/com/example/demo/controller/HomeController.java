package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository repo;
	
	@RequestMapping("/home")
	public String home() {
		return "Registration";
	}
	
	@RequestMapping("/")
	@ResponseBody
	public String Empty()
	{
		return "Hello Home from FullStackProject";
	}
	
	@RequestMapping("/getData")
	public String getData(HttpServletRequest req) {
		String uname=req.getParameter("username");
		String pass=req.getParameter("password");
		
		HttpSession session=req.getSession();
		session.setAttribute("uname1", uname);
		session.setAttribute("pass1", pass);
		return "home";
	}
	
	@RequestMapping("/getLoginData")
	public ModelAndView getLoginData(@RequestParam("username") String uname,@RequestParam("password") String pass) {
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("username1",uname);
		mv.addObject("password1",pass);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/getUserData")
	public ModelAndView getUserData(User user)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("user1",user);
		mv.setViewName("home");
		//repo.save(user);
		return mv;
	}
}

