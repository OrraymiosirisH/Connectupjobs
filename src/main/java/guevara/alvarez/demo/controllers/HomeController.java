package guevara.alvarez.demo.controllers;

import guevara.alvarez.demo.configs.UserService;
import guevara.alvarez.demo.models.Role;
import guevara.alvarez.demo.models.User;
import guevara.alvarez.demo.repositories.RoleRepository;
import guevara.alvarez.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
    public class HomeController {


        @Autowired
        UserRepository userRepository;
        @Autowired
        RoleRepository roleRepository;

        @Autowired
        private UserService userService;

        @RequestMapping("/")
        public String index()
        {
            return"index";
        }
        @RequestMapping("/login")
        public String logon(){
            return"login";
        }


@RequestMapping(value="/signup", method = RequestMethod.GET)
    public String showRegistrationPage(Model model){

            model.addAttribute("user", new User());
            return "signup";
}

@RequestMapping(value = "signup", method = RequestMethod.POST)
    public String processRegistrationPage



























//        @RequestMapping("/admin")
//        public String admin(){
//            return "admin";
//        }
//
//        @RequestMapping("/secure")
//        public String secure(){
//            return "secure";
//        }
//




//        @RequestMapping("/signup")
//
//        public String signUp( Model model){
//            User newuser=new User();
//            model.addAttribute("newuser", newuser);
//            Iterable<Role>test= roleRepository.findAllById(new Long(1));
//            for(Role item : test)
//            {
//                System.out.println(item.getRole());
//            }
//            return"signup";
//        }
//        @PostMapping("/signup")
//        public String proccessNew(@ModelAttribute("newuser") User otheruser){
//
//            otheruser.setEnabled(true);
//
//
//            Role newrole=roleRepository.findByRole("USER");
//
//            otheruser.addRole(newrole);
//
//
//            userRepository.save(otheruser);
//
//
//            return"popnew";
//        }

    }
