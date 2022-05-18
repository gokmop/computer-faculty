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
@RequestMapping("/teachers")
public class TeacherMvcController {

    private final TeacherService teacherService;

    private final JournalService journalService;

    private final DisciplineService disciplineService;

    private final StudentService studentService;

    @Autowired
    public TeacherMvcController(TeacherService teacherService, JournalService journalService, DisciplineService disciplineService, StudentService studentService) {
        this.teacherService = teacherService;
        this.journalService = journalService;
        this.disciplineService = disciplineService;
        this.studentService = studentService;
    }

    @GetMapping
    public String showAllTeachersPage(Model model){
        model.addAttribute("teachers", teacherService.getAll());
        return "teachers-order-by-first-name";
    }

    @GetMapping("last-name")
    public String showAllTeachersPageLastName(Model model){
        model.addAttribute("teachers", teacherService.sortByLastName());
        return "teachers-order-by-last-name";
    }

    @GetMapping("students")
    public String showAllTeachersByTitle(Model model){
        model.addAttribute("teachers", teacherService.sortByStudents());
        return "teachers-order-by-students";
    }

    @GetMapping("disciplines")
    public String showAllTeachersByDisciplineCount(Model model){
        model.addAttribute("teachers", teacherService.sortByDisciplines());
        return "teachers-order-by-disciplines";
    }

    @GetMapping("top-3")
    public String showTop3TeachersByStudents(Model model){
        model.addAttribute("teachers", teacherService.top3Teachers());
        return "teachers-order-by-top-3";
    }

}
