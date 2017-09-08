package guevara.alvarez.demo.controllers;


import guevara.alvarez.demo.models.Job;
import guevara.alvarez.demo.models.Skill;
import guevara.alvarez.demo.repositories.SkillRepository;
import guevara.alvarez.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

//@Controller
//@RequestMapping("/connect")
//public class ConnectController {
//
//    @Autowired
//    SkillRepository skillRepo;
//


//
//    @GetMapping("/addjob")

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
//        skillRepo.save(depskill);
//
//        return "jobform";
//    }
//
//    public String addBook(Model model) {
//        model.addAttribute("job", new Job());
//
//        Iterable<Job> depalist = skillRepo.findAll();
//        model.addAttribute("dep", depalist);
//
//
//
//
//        return "jobform";
//    }
//
//    @PostMapping("/addjob")
//    public String processBook(@ModelAttribute Job job, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "jobform";
//        }
//        skillRepo.save(job);
//        return "redirect:/connect/listjob";
//    }
//}