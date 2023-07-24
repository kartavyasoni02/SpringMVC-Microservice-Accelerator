package com.yash.accelerator.cofiguration;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * The accounts web-application. This class has two uses:
 * <ol>
 * <li>Provide configuration and setup for {@link WebServer} ... or</li>
 * <li>Run as a stand-alone Spring Boot web-application for testing (in which
 * case there is <i>no</i> microservice registration</li>
 * </ol>
 * <p>
 * To execute as a microservice, run {@link WebServer} instead.
 * 
 * @author kartavya.soni
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.yash.accelerator")
public class ApplicationConfiguration {

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfiguration.class, args);
	}
	 @Bean
     public ReloadableResourceBundleMessageSource messageSource() {
             ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
             messageSource.setBasename("classpath:validation");
             messageSource.setCacheSeconds(10); //reload messages every 10 seconds
             return messageSource;
     }
}
