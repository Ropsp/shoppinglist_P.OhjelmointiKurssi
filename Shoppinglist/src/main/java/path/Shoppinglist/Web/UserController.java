package path.Shoppinglist.Web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import path.Shoppinglist.domain.Register;
import path.Shoppinglist.domain.User;
import path.Shoppinglist.domain.UserRepository;

@Controller
public class UserController {
@Autowired
private UserRepository repository;

@RequestMapping (value = "register")
public String addItem(Model model) {
	model.addAttribute("registerform", new Register());
	return "register";
}
/**
 * Create new user
 * Check if user already exists & form validation
 * 
 * @param signupForm
 * @param bindingResult
 * @return
 */
@RequestMapping(value = "saveuser", method = RequestMethod.POST)
public String save(@Valid @ModelAttribute("registerform") Register registerForm, BindingResult bindingResult) {
	if (!bindingResult.hasErrors()) { // validation errors
		if (registerForm.getPassword().equals(registerForm.getPasswordCheck())) { // check password match		
    		String password = registerForm.getPassword();
	    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
	    	String hashPassword = bc.encode(password);

	    	User newUser = new User();
	    	newUser.setPasswordHash(hashPassword);
	    	newUser.setUsername(registerForm.getUsername());
	    	newUser.setRole("USER");
	    	if (repository.findByUsername(registerForm.getUsername()) == null) { // Check if user exists
	    		repository.save(newUser);
	    	}
	    	else {
    			bindingResult.rejectValue("username", "err.username", "Username already exists");    	
    			return "register";		    		
	    	}
		}
		else {
			bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");    	
			return "register";
		}
	}
	else {
		return "register";
	}
	return "redirect:/login";    	
} 

}
