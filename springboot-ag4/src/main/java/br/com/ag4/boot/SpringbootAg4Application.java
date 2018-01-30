package br.com.ag4.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class SpringbootAg4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAg4Application.class, args);
	}
	
	@RequestMapping("/") 
	String home(ModelMap modal) {
		modal.addAttribute("title", "CRUD AngularJS");
		return "src/index";
	}

}
