package com.csdepartment.csdepartment.controllers.mvc;

import com.csdepartment.csdepartment.models.dto.CreateStudentDto;
import com.csdepartment.csdepartment.models.Student;
import com.csdepartment.csdepartment.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentMvcController {

    private final StudentService studentService;

    @Autowired
    public StudentMvcController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String showAllStudentsPage(Model model){
        model.addAttribute("students", studentService.getAll());
        return "students";
    }

    @GetMapping("/new")
    public String getCreateStudentPage(Model model){
        model.addAttribute("createStudentDto", new CreateStudentDto());
        return "createStudent";
    }

    @PostMapping("/new")
    public String handleCreateStudent(@ModelAttribute CreateStudentDto dto, BindingResult bindingResult, Model model){
        model.addAttribute("createStudentDto", new CreateStudentDto());
        if (bindingResult.hasErrors()){
            return "createStudent";
        }
        Student studentToCreate = toStudent(dto);
        studentService.create(studentToCreate);


        model.addAttribute("service", studentService.getAll());

        return "redirect:/students";
    }

    private Student toStudent(@ModelAttribute CreateStudentDto dto){
        Student studentToCreate = new Student();
        studentToCreate.setFirstName(dto.getFirstName());
        studentToCreate.setLastName(dto.getLastName());
        studentToCreate.setYearInUni(dto.getYearInUni());
        return studentToCreate;
    }
}
