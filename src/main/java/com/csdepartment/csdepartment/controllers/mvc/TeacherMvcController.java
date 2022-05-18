package com.csdepartment.csdepartment.controllers.mvc;

import com.csdepartment.csdepartment.models.Discipline;
import com.csdepartment.csdepartment.models.Teacher;
import com.csdepartment.csdepartment.models.dto.CreateTeacherDto;
import com.csdepartment.csdepartment.models.mappers.TeacherMapper;
import com.csdepartment.csdepartment.services.DisciplineService;
import com.csdepartment.csdepartment.services.JournalService;
import com.csdepartment.csdepartment.services.StudentService;
import com.csdepartment.csdepartment.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherMvcController {

    private final TeacherService teacherService;

    private final JournalService journalService;

    private final DisciplineService disciplineService;

    private final StudentService studentService;

    private final TeacherMapper teacherMapper;

    @Autowired
    public TeacherMvcController(TeacherService teacherService, JournalService journalService, DisciplineService disciplineService, StudentService studentService, TeacherMapper teacherMapper) {
        this.teacherService = teacherService;
        this.journalService = journalService;
        this.disciplineService = disciplineService;
        this.studentService = studentService;
        this.teacherMapper = teacherMapper;
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

    @GetMapping("/new")
    public String getCreateTeacherPage(Model model){
       model.addAttribute("CreateTeacherDto", new CreateTeacherDto());
       return "create-teacher";
    }

    @PostMapping("/new")
    public String handleCreateTeacher(@ModelAttribute CreateTeacherDto dto, BindingResult bindingResult, Model model){
        model.addAttribute("CreateTeacherDto", new CreateTeacherDto());
        if (bindingResult.hasErrors()){
            return "create-teacher";
        }
        Teacher teacherToCreate = teacherMapper.fromDto(dto);

        model.addAttribute("service", teacherService.getAll());

        return "redirect:/teachers";
    }

    @GetMapping("/{id}")
    public String getTeacherProfile(@PathVariable Integer id, Model model){
        Teacher teacher = teacherService.getById(id);
        List<Discipline> listOfDisciplines = disciplineService.filterByTeacherId(id);

        model.addAttribute("teacher", teacher);
        model.addAttribute("disciplines", listOfDisciplines);
        return "teacher-profile";
    }

}
