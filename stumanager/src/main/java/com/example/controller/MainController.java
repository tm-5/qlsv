package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entity.Student;
import com.example.entity.Subject;
import com.example.entity.Teacher;
import com.example.entity.User;
import com.example.repository.SubjectRepository;
import com.example.repository.UserRepository;


@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    
    @GetMapping("/logout")
    public String backLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    
    @GetMapping("/home")
    public String home(Model model) {
        List<Subject> subjects = subjectRepository.findAll();
        model.addAttribute("subjects", subjects);

        return "home";
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model, RedirectAttributes redirectAttributes) {
    	
        if(user.getUserId().equals("admin") && user.getPassword().equals("admin")) {
        	model.addAttribute("student", new Student());
        	model.addAttribute("teacher", new Teacher());
        	redirectAttributes.addFlashAttribute("successLog", "Đăng nhập thành công.");
        	return "admin_home";
        }
        else if (userRepository.findByUserId(user.getUserId())!= null && userRepository.findByUserId(user.getUserId()).getPassword().equals(user.getPassword())) {
        	List<Subject> subjects = subjectRepository.findAll();
            model.addAttribute("subjects", subjects);
            redirectAttributes.addFlashAttribute("successLog", "Đăng nhập thành công.");
            return "home";
        } else {
            model.addAttribute("loginError", true);
            return "login";
        }
    }
}