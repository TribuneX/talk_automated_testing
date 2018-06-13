package de.itemis.registerpage;

import de.itemis.registerpage.model.User;
import de.itemis.registerpage.verification.PasswordVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class RegisterPageController {

    @Autowired
    public RegisterPageController(){

    }

    @RequestMapping(value="/")
    public String home(){
        return "index";
    }

    @RequestMapping(value="/greeting")
    public String greetingPage(@RequestParam(value="username") String username, Model model){
       model.addAttribute("name", username);
       return "greeting";
    }

    @RequestMapping(value = "/register")
    public String showRegisterPage(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("message", "");
        return "register";
    }

    @PostMapping(value="/register")
    public String processRegistration(@ModelAttribute User user, Model model) {
        if (PasswordVerifier.verify(user.getPassword())){
            return "redirect:/greeting?username=" + user.getUsername();
        } else {
            model.addAttribute("user", new User());
            model.addAttribute("message",PasswordVerifier.getVerficationString(user.getPassword()));
            return "register";
        }

    }



}
