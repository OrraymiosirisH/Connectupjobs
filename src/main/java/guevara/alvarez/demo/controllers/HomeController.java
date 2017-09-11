package guevara.alvarez.demo.controllers;

import guevara.alvarez.demo.configs.UserService;
import guevara.alvarez.demo.models.Job;
import guevara.alvarez.demo.models.Role;
import guevara.alvarez.demo.models.Skill;
import guevara.alvarez.demo.models.User;
import guevara.alvarez.demo.repositories.JobRepository;
import guevara.alvarez.demo.repositories.RoleRepository;
import guevara.alvarez.demo.repositories.SkillRepository;
import guevara.alvarez.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;

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

    @Autowired
    JobRepository jobRepository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

//    public String loadskill(Model model) {
//        model.addAttribute("skill", new Skill());
//
//
//        Iterable<Skill> depskill;
//        ArrayList<Skill> toadd = new ArrayList<>();
//
//
//        Skill newDepa1 = new Skill();
//        newDepa1.setSki("Typing");
//
//        Skill newDepa2 = new Skill();
//        newDepa2.setSki("Programming");
//
//        Skill newDepa3 = new Skill();
//        newDepa3.setSki("Networking");
//
//        Skill newDepa4 = new Skill();
//        newDepa4.setSki("Weightlifting");
//
//        toadd.add(newDepa1);
//        toadd.add(newDepa2);
//        toadd.add(newDepa3);
//        toadd.add(newDepa4);
//
//        depskill = toadd;
//
//
//        Iterable<Role> deprole;
//        ArrayList<Role> toaddrole = new ArrayList<>();
//
//
//        Role newR1 = new Role();
//        newR1.setRole("SEEKER");
//
//        Role newR2 = new Role();
//        newR2.setRole("RECRU");
//
//
//        toaddrole.add(newR1);
//        toaddrole.add(newR2);
//
//        deprole=toaddrole;
//
//
//        roleRepository.save(deprole);
//        skillRepo.save(depskill);
//
//        return "index";
//    }



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


    @GetMapping("/newpost")
    public String addPost(Model model) {
        model.addAttribute("reslist", skillRepo.findAll());
        model.addAttribute("job", new Job());
        return "newpost";
    }

    @PostMapping("/newpost")
    public String processPost(@Valid @ModelAttribute("job") Job job, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("**Errors");
            return "newpost";
        }
        System.out.println("**NO Errors");
        job.setEnabled(true);
//        job.setSkiller(Arrays.asList(skillRepo.findAllByski(id)));
        jobRepository.save(job);
        return "redirect:/newpost";

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
