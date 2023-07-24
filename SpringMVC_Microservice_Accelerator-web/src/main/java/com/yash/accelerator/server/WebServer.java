package com.yash.accelerator.server;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.yash.accelerator.cofiguration.ApplicationConfiguration;

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link ApplicationConfiguration}. This is a deliberate separation of concerns
 * and allows the application to run:
 * <ul>
 * <li>Standalone - by executing {@link ApplicationConfiguration#main(String[])}</li>
 * <li>As a microservice - by executing {@link WebServer#main(String[])}</li>
 * </ul>
 * 
 * @author kartavya.soni
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(ApplicationConfiguration.class)
public class WebServer {

	protected Logger logger = Logger.getLogger(WebServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for web-server.properties or
		// web-server.yml
		System.setProperty("spring.config.name", "web-server");

		SpringApplication.run(WebServer.class, args);
	}
}
