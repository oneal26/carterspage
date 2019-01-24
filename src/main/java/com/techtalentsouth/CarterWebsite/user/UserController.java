package com.techtalentsouth.CarterWebsite.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techtalentsouth.CarterWebsite.user.UserRepository;
import com.techtalentsouth.CarterWebsite.user.User;

@Controller
@RequestMapping
public class UserController {
	
	@Autowired
	private UserRepository UserRepository;
	
	@GetMapping("/")
	public String index(User user) {
		return	"user/index.html";
	}
	
	
	@GetMapping("about")
	public String about() {
		return "user/about.html";
	}
	
	@GetMapping("contact")
	public String contact() {
		return "user/contact-us.html";
	}
	
	@GetMapping("result")
	public String result(User user) {
		return "user/result.html";
	}
	
	@GetMapping("signup")
	public String signup(User user) {
		return "user/sign-up.html";
	}
	

	@RequestMapping( value="/signup", method = RequestMethod.POST)
	@PostMapping(value="signup")
	public String addNewUser(User user, Model model) {
		
		UserRepository.save(new User(user.getUserName(), user.getPassWord()));
		model.addAttribute("userName", user.getUserName());
		model.addAttribute("passWord", user.getPassWord());
		
		return "user/result";
	}
	

	
	
	

	

	
}
