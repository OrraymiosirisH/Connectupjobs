//package guevara.alvarez.demo.controllers;
//
//
//import guevara.alvarez.demo.configs.UserService;
//import guevara.alvarez.demo.models.Job;
//import guevara.alvarez.demo.models.Skill;
//import guevara.alvarez.demo.repositories.JobRepository;
//import guevara.alvarez.demo.repositories.SkillRepository;
//import guevara.alvarez.demo.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.validation.Valid;
//import java.util.ArrayList;
//
//@Controller
//@RequestMapping("/connect")
//
//public class ConnectController {
//
//    @Autowired
//    SkillRepository skillRepo;
//
//    @Autowired
//    JobRepository jobRepository;
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/newpost")
//    public String addPost(Model model) {
//        model.addAttribute("reslist", skillRepo.findAll());
//        model.addAttribute("job", new Job());
//        return "newpost";
//    }
//
//    @PostMapping("/newpost")
//    public String processPost(@Valid @ModelAttribute("job") Job job, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            System.out.println("**Errors");
//            return "newpost";
//        }
//        System.out.println("**NO Errors");
//        jobRepository.save(job);
//        return "redirect:/index";
//
//    }
//}