package com.flowers.conniecodetest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/greeting")
	public String greeting() {
		return "Hello Spring Boot, Connie is trying to build.";
	}
}
