package com.yash.accelerator.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.yash.accelerator.configuration.SignInApplicationConfiguration;


/**
 * Accounts web-server. Works as a microservice client, fetching data from the
 * Account-Service. Uses the Discovery Server (Eureka) to find the microservice.
 * 
 * @author kartavya.soni
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
// Disable component scanner ...
@Import(SignInApplicationConfiguration.class)
public class SignInServer {

	/**application.properties
	 * URL uses the logical name of signin-service - upper or lower case,
	 * doesn't matter.
	 */

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for web-server.properties or web-server.yml
		System.setProperty("spring.config.name", "signin-server");
		SpringApplication.run(SignInServer.class, args);
	}


}
