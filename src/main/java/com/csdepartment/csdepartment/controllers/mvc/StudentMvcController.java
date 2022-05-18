package com.csdepartment.csdepartment.controllers.mvc;

import com.csdepartment.csdepartment.models.Journal;
import com.csdepartment.csdepartment.models.Student;
import com.csdepartment.csdepartment.models.dto.CreateStudentDto;
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
@RequestMapping("/students")
public class StudentMvcController {

    private final StudentService studentService;
    private final JournalService journalService;
    private final TeacherService teacherService;
    private final DisciplineService disciplineService;

    @Autowired
    public StudentMvcController(StudentService studentService, JournalService journalService, TeacherService teacherService, DisciplineService disciplineService) {
        this.studentService = studentService;
        this.journalService = journalService;
        this.teacherService = teacherService;
        this.disciplineService = disciplineService;
    }

    @GetMapping
    public String showAllStudentsPage(Model model){
        model.addAttribute("students", studentService.getAll());
        return "students";
    }

    @GetMapping("last-name")
    public String showAllStudentsPageLastName(Model model){
        model.addAttribute("students", studentService.sortByLastName());
        return "students-order-by-last-name";
    }

    @GetMapping("year-in-uni")
    public String showAllStudentsPageYearInUni(Model model){
        model.addAttribute("students", studentService.sortByYearInUni());
        return "students-order-by-year-in-uni";
    }

    @GetMapping("credits")
    public String showAllStudentsPageCredits(Model model){
        model.addAttribute("students", studentService.sortByCredits());
        return "students-order-by-credits";
    }

    @GetMapping("top-3")
    public String showTop3Students(Model model){
        model.addAttribute("students", studentService.top3Students());
        return "students-order-by-top-3";
    }

    @GetMapping("/new")
    public String getCreateStudentPage(Model model){
        model.addAttribute("createStudentDto", new CreateStudentDto());
        return "createStudent";
    }

    @GetMapping("/{id}")
    public String getStudentProfile(@PathVariable Integer id, Model model){
        Student student = studentService.getById(id);
        List<Journal> listOfDisciplines = journalService.filterByStudentId(id);


        model.addAttribute("student", studentService.getById(id));
        model.addAttribute("journal", listOfDisciplines);


        return "student-profile";
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
