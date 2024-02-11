package za.ac.cput.validation.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.validation.Models.LoginModel;

@Controller
//the default path of this controlllers functions
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/")
    public String displayLoginForm(Model model){
        model.addAttribute("loginModel", new LoginModel());
        return "LoginForm";
    }

    @PostMapping("/processLogin")
    public String processLoginForm(Model model, LoginModel loginModel){
        model.addAttribute("loginModel", loginModel);
        System.out.println(loginModel);
        return "LoginResults";
    }
}
