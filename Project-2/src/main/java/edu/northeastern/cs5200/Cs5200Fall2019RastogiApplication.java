package edu.northeastern.cs5200;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * The Class Cs5200Fall2019RastogiApplication.
 */
@SpringBootApplication
public class Cs5200Fall2019RastogiApplication extends SpringBootServletInitializer {

	/**
	 * Configure.
	 *
	 * @param application the application
	 * @return the spring application builder
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Cs5200Fall2019RastogiApplication.class);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Cs5200Fall2019RastogiApplication.class, args);
	}

}
