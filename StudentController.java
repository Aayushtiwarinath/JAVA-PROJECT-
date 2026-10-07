package com.aayu.studentcrud.controller;

import com.aayu.studentcrud.model.Student;
import com.aayu.studentcrud.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) { this.service = service; }

    // READ - list + search
    @GetMapping
    public String list(@RequestParam(required = false) String keyword, Model model) {
        model.addAttribute("students", service.findAll(keyword));
        model.addAttribute("keyword", keyword);
        return "students/list";
    }

    // CREATE - show form
    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("title", "Add Student");
        return "students/form";
    }

    // UPDATE - show form
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.findById(id));
        model.addAttribute("title", "Edit Student");
        return "students/form";
    }

    // CREATE / UPDATE - submit
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("student") Student student,
                       BindingResult result, Model model, RedirectAttributes ra) {
        String title = student.getId() == null ? "Add Student" : "Edit Student";
        if (result.hasErrors()) {
            model.addAttribute("title", title);
            return "students/form";
        }
        try {
            service.save(student);
            ra.addFlashAttribute("msg", "Student saved successfully!");
        } catch (DataIntegrityViolationException e) {
            result.rejectValue("email", "duplicate", "This email is already registered");
            model.addAttribute("title", title);
            return "students/form";
        }
        return "redirect:/students";
    }

    // DELETE
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes ra) {
        service.delete(id);
        ra.addFlashAttribute("msg", "Student deleted.");
        return "redirect:/students";
    }
}
