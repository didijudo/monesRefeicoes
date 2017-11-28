package br.com.mones.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.mones.model.User;
import br.com.mones.model.UserBean;
import br.com.mones.repository.UserRepository;

@Controller
public class HomeController {
	
	@Autowired
	private UserBean sessionUser;
	@Autowired
	private UserRepository repo;
	
	@RequestMapping("/")
	public String index() {		
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String login, String password, HttpSession session, Model m) {
        User user = repo.findByUsername(login);
        if (user.getPassword().equals(password)) {
        		sessionUser.setUsuario(user);
        		return "redirect:/home";
        } else {
        	return "erro";
        }
	}
    
	@RequestMapping("/home")
	public String home(Model m) {
		User u = sessionUser.getUsuario();
		System.out.println(u.getUsername());
		m.addAttribute("user", u);
		return "home";
	}
	
	@RequestMapping("/gera")
	@ResponseBody
	public String createUser() {
		User u = new User();
		u.setUsername("admin");
		u.setPassword("123");
		
		repo.save(u);
		return "Usuario adm criado com sucesso";
	}
}
