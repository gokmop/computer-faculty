package com.csdepartment.csdepartment.controllers.mvc;

import com.csdepartment.csdepartment.services.DisciplineService;
import com.csdepartment.csdepartment.services.JournalService;
import com.csdepartment.csdepartment.services.StudentService;
import com.csdepartment.csdepartment.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeMvcController {

    private final StudentService studentService;

    private final TeacherService teacherService;

    private final DisciplineService disciplineService;

    private final JournalService journalService;

    @Autowired
    public HomeMvcController(StudentService studentService, TeacherService teacherService, DisciplineService disciplineService, JournalService journalService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.disciplineService = disciplineService;
        this.journalService = journalService;
    }

    @GetMapping
    public String showHomePage(Model model){
        model.addAttribute("disciplines", disciplineService.getAll());
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("teachers", teacherService.getAll());
        model.addAttribute("journals", journalService.getAll());

        return "home-page";
    }
}
