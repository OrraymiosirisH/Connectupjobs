package guevara.alvarez.demo.controllers;

import guevara.alvarez.demo.configs.UserService;
import guevara.alvarez.demo.models.Role;
import guevara.alvarez.demo.models.Skill;
import guevara.alvarez.demo.models.User;
import guevara.alvarez.demo.repositories.RoleRepository;
import guevara.alvarez.demo.repositories.SkillRepository;
import guevara.alvarez.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
    public class HomeController {


    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    @Autowired
    SkillRepository skillRepo;

    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }

    public String loadskill(Model model) {
        model.addAttribute("skill", new Skill());


        Iterable<Skill> depskill;
        ArrayList<Skill> toadd = new ArrayList<>();


        Skill newDepa1 = new Skill();
        newDepa1.setSki("Typing");

        Skill newDepa2 = new Skill();
        newDepa2.setSki("Programming");

        Skill newDepa3 = new Skill();
        newDepa3.setSki("Networking");

        Skill newDepa4 = new Skill();
        newDepa4.setSki("Weightlifting");

        toadd.add(newDepa1);
        toadd.add(newDepa2);
        toadd.add(newDepa3);
        toadd.add(newDepa4);

        depskill = toadd;

        skillRepo.save(depskill);

        return "index";
    }



    @RequestMapping("/login")
    public String logon() {
        return "login";
    }


    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String showRegistrationPage(Model model) {

        model.addAttribute("user", new User());
//        model.addAttribute("allrole", roleRepository.findAll());

        return "signup";


    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

        model.addAttribute("user", user);

        if (result.hasErrors()) {
    return "signup";

}  else {
            userService.saveSeeker(user);
            model.addAttribute("message", "Seeker Account Successfully Created");
        }

        return "index";

    }




    @RequestMapping(value = "/recrureg", method = RequestMethod.GET)
    public String showRegistrationPage2(Model model) {

        model.addAttribute("user", new User());
//        model.addAttribute("allrole", roleRepository.findAll());

        return "recrureg";

    }

    @RequestMapping(value = "recrureg", method = RequestMethod.POST)
    public String processRegistrationPage2(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

        model.addAttribute("user", user);

        if (result.hasErrors()) {
            return "recrureg";

        }  else {
            userService.saveRecru(user);
            model.addAttribute("message", "Recruiter Account Successfully Created");
        }

        return "index";

    }

























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
