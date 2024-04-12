package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entity.*;
import com.example.repository.*;

@Controller

public class CreateNewController {
	@Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentRepository studentRepository;
    
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {
    	if (studentRepository.existsById(student.getStudentID())) {
    		redirectAttributes.addFlashAttribute("successMess", "Tài khoản đã tồn tại");
    		return "redirect:/admin_home";
        }
    	User u=new User();
    	u.setRole("student");
    	u.setUserId(student.getStudentID());
    	u.setPassword(student.getStudentID());
    	userRepository.save(u);
    	student.setUser(u);
    	studentRepository.save(student);
    	redirectAttributes.addFlashAttribute("successMessage", "Thêm mới thành công");
    	return "redirect:/admin_home";
    }
    
    @PostMapping("/saveTeacher")
    public String saveStudent(@ModelAttribute("teacher") Teacher teacher,  RedirectAttributes redirectAttributes) {
    	if (teacherRepository.existsById(teacher.getTeacherID())) {
    		redirectAttributes.addFlashAttribute("successMess", "Tài khoản đã tồn tại");
            
            return "redirect:/admin_home";
        }
    	User u=new User();
    	u.setRole("teacher");
    	u.setUserId(teacher.getTeacherID());
    	u.setPassword(teacher.getTeacherID());
    	userRepository.save(u);
    	teacher.setUser(u);
    	teacherRepository.save(teacher);
    	redirectAttributes.addFlashAttribute("successMessage", "Thêm mới thành công");
    	return "redirect:/admin_home";
    }
}
