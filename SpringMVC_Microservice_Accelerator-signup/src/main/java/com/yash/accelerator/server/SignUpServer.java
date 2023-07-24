package com.yash.accelerator.server;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.yash.accelerator.configuration.SignUpApplicationConfiguration;

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link SignUpServer}. This is a deliberate separation of concerns
 * and allows the application to run:
 * <ul>
 * <li>Standalone - by executing {@link SignUpApplicationConfiguration#main(String[])}</li>
 * <li>As a microservice - by executing {@link SignUpServer#main(String[])}</li>
 * </ul>
 * 
 * @author kartavya.soni
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(SignUpApplicationConfiguration.class)
public class SignUpServer {

	/*@Autowired
	protected AccountRepository accountRepository;*/

	protected Logger logger = Logger.getLogger(SignUpServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for signup-server.properties or
		// signup-server.yml
		System.setProperty("spring.config.name", "signup-server");

		SpringApplication.run(SignUpServer.class, args);
	}
}
