package com.rahul.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class HelloWorldController {

	// http://localhost:8080/hello
	@GetMapping("/hello")
	public String helloWorld() {
		return "hello world";

	}

}
