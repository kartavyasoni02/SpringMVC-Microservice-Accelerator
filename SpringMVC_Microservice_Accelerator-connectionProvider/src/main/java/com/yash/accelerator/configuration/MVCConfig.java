package com.yash.accelerator.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@PropertySource(value = { "classpath:application.properties" })
public class MVCConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment environment;

/*	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("/login");
	}*/

	@Bean
	public InternalResourceViewResolver viewResolver() throws Exception{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix(environment.getRequiredProperty("resolver.setPrefix"));
		resolver.setSuffix(environment.getRequiredProperty("resolver.setSuffix"));
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	} 
}