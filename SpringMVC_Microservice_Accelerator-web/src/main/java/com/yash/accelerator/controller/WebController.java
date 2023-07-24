package com.yash.accelerator.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yash.accelerator.model.Employee;
import com.yash.accelerator.validation.UserFormValidator;
/**
 * web Controller call rest service to signin and signup microservice and bind data to jsp pages
 * @author kartavya.soni
 *
 */
/**
 * web Controller call rest service to signin and signup microservice and bind data to jsp pages
 * @author kartavya.soni
 *
 */
@Controller
@PropertySource(value = { "classpath:discovery-clients.properties" })
public class WebController {
	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	UserFormValidator validator;

	protected Logger logger = Logger.getLogger(WebController.class
			.getName());

	/**
	 * The RestTemplate works because it uses a custom request-factory that uses
	 * Ribbon to look-up the service to use. This method simply exists to show
	 * this.
	 */
	@PostConstruct
	public void demoOnly() {
		// Can't do this in the constructor because the RestTemplate injection
		// happens afterwards.
		logger.warning("The RestTemplate request factory is "
				+ restTemplate.getRequestFactory());
	}

	@RequestMapping("users")
	public String getuser(Model model){
		logger.info("getuser() invoked:");
		@SuppressWarnings("unchecked")
		List<Employee> usersMap = restTemplate.getForObject(environment.getRequiredProperty("signupURL")+"/getEmployees", List.class);
		model.addAttribute("listUsers", usersMap);
		return "users";
	}
	@RequestMapping("view/{id}")
	public String getEmployee(@PathVariable("id") Integer id,Model model){
		logger.info("getEmployee() invoked: based on id "+id);
		@SuppressWarnings("unchecked")
		
		List<Employee> usersMap = restTemplate.getForObject(environment.getRequiredProperty("signupURL")+"/getEmployees?employeeId="+id+"", List.class);

		if(usersMap!=null){
			model.addAttribute("listUsers", usersMap);
		}else{
			logger.info("No user exist----------");
		}
		return "employee";
	}
	@RequestMapping(value={"/","/login"})  
	public ModelAndView getLogin() {  
		logger.info("in /login page");
		return new ModelAndView("login","employee",new Employee());  
	} 
	
	
	
	
	@RequestMapping(value="/signin",method=RequestMethod.POST)  
	public String checkLogin(@ModelAttribute("employee") Employee employee ,Model model,BindingResult result,final RedirectAttributes redirectAttributes) throws Exception {
		validator.validate(employee, result);
		
		if (result.hasFieldErrors("userName")||result.hasFieldErrors("password")) {
			
			logger.info("/****************** inside user/add"+result.getObjectName());
			return "login";
		} 
		logger.info("in /signin page");
		boolean flag = restTemplate.postForObject( environment.getRequiredProperty("signinURL")+"/signin", employee, Boolean.class);
		
		if(flag){
			@SuppressWarnings("unchecked")
			List<Employee> usersMap = restTemplate.getForObject(environment.getRequiredProperty("signupURL")+"/getEmployees", List.class);

			if(usersMap!=null){
				model.addAttribute("listUsers", usersMap);
			}
			return "users";
		}
		return "login"; 
	} 
	@RequestMapping(value="/signup",method=RequestMethod.POST)  
	public String signupEmployee(@ModelAttribute("employee") Employee employee ,Model model,BindingResult result,final RedirectAttributes redirectAttributes) throws Exception {
		validator.validate(employee, result);

		if (result.hasErrors()) {
			logger.info("/****************** inside user/add"+result.getObjectName());
			return "registration";
		}  
		logger.info("in /signin page");
		Integer output = restTemplate.postForObject( environment.getRequiredProperty("signupURL")+"/saveOrUpdateEmployee", employee, Integer.class);

		if(output!=null && output.intValue()==1){
			@SuppressWarnings("unchecked")
			List<Employee> usersMap = restTemplate.getForObject(environment.getRequiredProperty("signupURL")+"/getEmployees", List.class);

			if(usersMap!=null){
				model.addAttribute("listUsers", usersMap);
			}
			return "users";
		}
		model.addAttribute("employee", employee);
		return "registration"; 
	} 
	@RequestMapping("/registration")  
	public ModelAndView getRegistration() {  
		logger.info("in /login page");
		return new ModelAndView("registration","employee",new Employee());  
	} 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage() {
		return "redirect:/login?logout";
	}
	
}
