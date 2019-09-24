package edu.northeastern.cs5200.controllers.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class HelloController.
 * 
 * @author Shubham Rastogi
 */
@RestController
public class HelloController {

	/**
	 * Say hello.
	 *
	 * @return the string
	 */
	@RequestMapping("/api/hello/string")
	public String sayHello() {
		return "Hello Shubham Rastogi!";
	}

	/**
	 * Say hello object.
	 *
	 * @return the hello object
	 */
	@RequestMapping("/api/hello/object")
	public HelloObject sayHelloObject() {
		return new HelloObject("Hello Shubham Rastogi!");
	}
}
