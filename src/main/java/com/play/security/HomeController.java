package com.play.security;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private HamesRealm hamesRealm;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String home(Model model) {
		if(SecurityUtils.getSubject().isAuthenticated()){
			return dashboard();
		}
		return "login";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login")
	public String login(Model model) {
		if(SecurityUtils.getSubject().isAuthenticated()){
			return "redirect:/";
		}
		return "login";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/dashboard")
	public String dashboard() {
		System.out.println("Afil Ansari");
		return "home";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(){
		SecurityUtils.getSubject().logout();
		return "redirect:login";
	}
	
}
