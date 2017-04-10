package com.example.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.constant.ViewConstant;

@Controller
public class LoginController {

	
	private static final Log LOG = LogFactory.getLog(LoginController.class);
	/*
	@GetMapping("/")
	public String redirectToLogin(){
		LOG.info("METHOD: redirectToLogin()");
		return "redirect:/login";
	}
	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name="error", required=false)String error,
			@RequestParam(name="logout", required=false) String logout){
		LOG.info("METHOD: showLoginForm() -- PARAMS: error=" + error + ", logout=" +  logout );
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredentials", new UserCredentials());
		LOG.info("Returning to login view");
		return ViewConstant.LOGIN;
	}
	*/
	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name="error", required=false)String error,
			@RequestParam(name="logout", required=false) String logout){
		LOG.info("METHOD: showLoginForm() -- PARAMS: error=" + error + ", logout=" +  logout );
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		LOG.info("Returning to login view");
		return ViewConstant.LOGIN;
	}
	
	@GetMapping({"/loginsuccess", "/"}) //la barra o login succes entraran por aqui
	public String loginCheck(){
		LOG.info("METHOD: loginCheck() ");
		LOG.info("Retornando a la vista contactos");
		return "redirect:/contacts/showcontacts";
	}
	
	/*
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name="userCredentials")UserCredentials userCredentials){
		LOG.info("METHOD: loginCheck() -- PARAMS: " + userCredentials.toString());
		if(userCredentials.getUsername().equals("user") && userCredentials.getPassword().equals("user")){
			LOG.info("Retornando a la vista contactos");
			return "redirect:/contacts/showcontacts";
		}
		LOG.info("Redirect to login?error");
		return "redirect:/login?error";
	}
	*/
	
}
