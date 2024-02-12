package za.ac.cput.validation.Controllers;

//make sure to use this import instead of javax
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    //the @Valid make sure that the model being passed has valid data, bindingResult holds the errors that we use to check
    public String processLoginForm(@Valid LoginModel loginModel, BindingResult bindingResult, Model model){
        System.out.println(bindingResult.hasErrors());
        if(bindingResult.hasErrors()){
            model.addAttribute("loginModel", loginModel);
            return "LoginForm";
        }
        model.addAttribute("loginModel", loginModel);
        System.out.println(loginModel);
        return "LoginResults";
    }
}
