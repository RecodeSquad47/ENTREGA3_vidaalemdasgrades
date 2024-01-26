package vidaalemdasgrades.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import vidaalemdasgrades.dto.UserDto;
import vidaalemdasgrades.model.User;
import vidaalemdasgrades.service.impl.UserService;

@RequestMapping
@Controller
public class AuthController {
	  @GetMapping("/")
	    public String home() {
	        return "views/home/home";
	    }

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "views/usuarios/login";
    }
    
    @GetMapping("/quemsomos")
    public String quemsomos() {
        return "views/quemsomos";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "views/register/register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model) {

        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "Já existe uma conta cadastrada com o mesmo email");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }
    
    @GetMapping("/users")
    public String users(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "views/usuarios/users";
    }
}
