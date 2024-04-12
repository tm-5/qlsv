package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entity.*;
import com.example.repository.*;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping("/admin_home")
    public String tohome(Model model) {
    	model.addAttribute("student", new Student());
    	model.addAttribute("teacher", new Teacher());
    	return "admin_home";
    }
    
    @GetMapping("/manage_grade")
    public String toGrd(Model model) {
    	List<Grade> list=gradeRepository.findAll();
    	model.addAttribute("list",list);
    	return "manage_grade";
    }
    
    @GetMapping("/manage_user")
    public String userList(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "manage_user"; 
    }
    @GetMapping("/editUser/{userId}")
    public String editUser(@PathVariable(value ="userId") String userId, Model model) {
        User user = userRepository.findByUserId(userId);
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        userRepository.save(user);
        redirectAttributes.addFlashAttribute("successMessage", "Cập nhật thành công.");
        return "redirect:/manage_user";
    }

    @GetMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable(value ="userId") String userId, RedirectAttributes redirectAttributes) {
        User user = userRepository.findByUserId(userId);
        userRepository.delete(user);
        redirectAttributes.addFlashAttribute("successMess", "Đã xóa người dùng.");
        return "redirect:/manage_user";
    }
    
    @GetMapping("/manage_teacher")
    public String teachers(Model model) {
    	List<Teacher> teachers = teacherRepository.findAll();
        model.addAttribute("teachers", teachers);
        return "manage_teacher";
    }
    
    @GetMapping("/deleteTeacher/{teacherID}")
    public String deleteTeacher(@PathVariable(value ="teacherID") String teacherID, RedirectAttributes redirectAttributes) {
        Optional<Teacher> t = teacherRepository.findById(teacherID);
        Teacher tc=t.get();
        User u=userRepository.findByUserId(tc.getTeacherID());
        userRepository.delete(u);
        //teacherRepository.delete(tc);
        redirectAttributes.addFlashAttribute("successMess", "Đã xóa giảng viên và user.");
        return "redirect:/manage_teacher";
    }
    
    @GetMapping("/manage_student")
    public String mnstudent(Model model) {
    	List<Student> students= studentRepository.findAll();
    	model.addAttribute("students",students);
    	return "manage_student";
    }
    
    @GetMapping("deleteStudent/{studentID}")
    public String del(@PathVariable(value ="studentID") String studentID, RedirectAttributes redirectAttributes){
    	Optional<Student> s=studentRepository.findById(studentID);
    	Student st=s.get();
    	User u=userRepository.findByUserId(st.getStudentID());
    	userRepository.delete(u);
    	studentRepository.delete(st);
    	redirectAttributes.addFlashAttribute("successMess", "Đã xóa sinh viên và user.");
        return "redirect:/manage_student";
    }
    
    @GetMapping("/editStudent/{studentID}")
    public String editStd(@PathVariable(value ="studentID") String studentID, Model model) {
        Optional<Student> s=studentRepository.findById(studentID);
        model.addAttribute("student", s.get());
        return "edit_student";
    }
    @PostMapping("/updateStudent")
    public String updateStd(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {
        studentRepository.save(student);
        redirectAttributes.addFlashAttribute("successMessage", "Cập nhật thành công.");
        return "redirect:/manage_student";
    }
    
    @GetMapping("/editTeacher/{teacherID}")
    public String editTch(@PathVariable(value ="teacherID") String teacherID, Model model) {
        Optional<Teacher> s=teacherRepository.findById(teacherID);
        model.addAttribute("teacher", s.get());
        return "edit_teacher";
    }
    @PostMapping("/updateTeacher")
    public String updateTch(@ModelAttribute("teacher") Teacher teacher, RedirectAttributes redirectAttributes) {
    	teacherRepository.save(teacher);
        redirectAttributes.addFlashAttribute("successMessage", "Cập nhật thành công.");
        return "redirect:/manage_teacher";
    }
}
