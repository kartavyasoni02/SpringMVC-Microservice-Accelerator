package com.yash.accelerator.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yash.accelerator.server.SignUpServer;

/**
 * The accounts web-application. This class has two uses:
 * <ol>
 * <li>Provide configuration and setup for {@link SignUpServer} ... or</li>
 * <li>Run as a stand-alone Spring Boot web-application for testing (in which
 * case there is <i>no</i> microservice registration</li>
 * </ol>
 * <p>
 * To execute as a microservice, run {@link SignUpServer} instead.
 * 
 * @author kartavya.soni
 */
@SpringBootApplication
public class SignUpApplicationConfiguration {

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		
		SpringApplication.run(SignUpApplicationConfiguration.class, args);
	}
}
