package com.codegym.student.controllers;

import com.codegym.student.models.Student;
import com.codegym.student.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "student")
public class StudentController {
@Autowired
private IStudentService studentService;
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("")
    public String displayAllStudents(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student/list";
}
    @GetMapping("/create")
    public String viewCreate() {
        return "student/create";
    }

    @PostMapping("/create")
    public String newStudent(@RequestParam("name") String name,
                             @RequestParam("address")String address,
                             @RequestParam("score") Float score,
                             RedirectAttributes redirect) {
        Student student = new Student(name, address, score);
        studentService.save(student);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/student";
    }
    @GetMapping("/update/{id}")
    public String viewUpdate(@PathVariable Long id,Model model) {
        System.out.println(id);
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "/student/update";
    }
    @PostMapping("/update")
    public String updateStudent(@RequestParam("id") Long id,
                                @RequestParam("name") String name,
                                @RequestParam("address") String address,
                                @RequestParam("score") Float score,
                                RedirectAttributes redirect) {
        Student student = studentService.findById(id);
        if (student != null) {
            student.setName(name);
            student.setAddress(address);
            student.setScore(score);
            studentService.save(student);
            redirect.addFlashAttribute("message", "Cập nhật thành công");
        } else {
            redirect.addFlashAttribute("message", "Không tìm thấy sinh viên với ID " + id);
        }
        return "redirect:/student";
    }
}
