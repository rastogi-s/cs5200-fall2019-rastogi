package edu.northeastern.cs5200.controllers.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class HelloController.
 * 
 * @author Shubham Rastogi
 */
@RestController
public class HelloController {

	/** The hello repository. */
	@Autowired
	private HelloRepository helloRepository;

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

	/**
	 * Insert hello object.
	 *
	 * @return the hello object
	 */
	@RequestMapping("/api/hello/insert")
	public HelloObject insertHelloObject() {
		HelloObject obj = new HelloObject("Hello Shubham Rastogi!");
		helloRepository.save(obj);
		return obj;
	}

	/**
	 * Insert message.
	 *
	 * @param message the message
	 * @return the hello object
	 */
	@RequestMapping("/api/hello/insert/{msg}")
	public HelloObject insertMessage(@PathVariable("msg") String message) {
		HelloObject obj = new HelloObject(message);
		helloRepository.save(obj);
		return obj;
	}

	/**
	 * Select all hello objects.
	 *
	 * @return the list
	 */
	@RequestMapping("/api/hello/select/all")
	public List<HelloObject> selectAllHelloObjects() {
		List<HelloObject> hellos = (List<HelloObject>) helloRepository.findAll();
		return hellos;
	}

}
