package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.service.TestService;

@Controller
public class TestCon {
	
	@Autowired
	TestService service;
	
	@RequestMapping("/testcon")
	@ResponseBody
	public String test() {
		System.out.println("1111");
		service.servicetest("1");
		return "index";
	}
}
