package com.csdepartment.csdepartment.controllers.mvc;

import com.csdepartment.csdepartment.models.Discipline;
import com.csdepartment.csdepartment.models.dto.CreateDisciplineDto;
import com.csdepartment.csdepartment.models.mappers.DisciplineMapper;
import com.csdepartment.csdepartment.services.DisciplineService;
import com.csdepartment.csdepartment.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/disciplines")
public class DisciplineMvcController {

    private final DisciplineService disciplineService;

    private final TeacherService teacherService;

    private final DisciplineMapper disciplineMapper;

    @Autowired
    public DisciplineMvcController(DisciplineService disciplineService, TeacherService teacherService, DisciplineMapper disciplineMapper) {
        this.disciplineService = disciplineService;
        this.teacherService = teacherService;
        this.disciplineMapper = disciplineMapper;
    }

    @GetMapping
    public String showAllDisciplinesOrderByName(Model model){
        model.addAttribute("disciplines", disciplineService.getAll());
        return "disciplines-order-by-name";
    }

    @GetMapping("/students")
    public String sortAllDisciplinesByStudentsCount(Model model){
        model.addAttribute("disciplines", disciplineService.sortByStudentsSigned());
        return "disciplines-order-by-students";
    }

    @GetMapping("/top-3")
    public String top3DisciplinesByStudents(Model model){
        model.addAttribute("disciplines", disciplineService.top3Disciplines());
        return "disciplines-order-by-top-3";
    }

    @GetMapping("/new")
    private String getCreateDisciplinePage(Model model){
        model.addAttribute("CreateDisciplineDto", new CreateDisciplineDto());
        model.addAttribute("teachers", teacherService.getAll());
        return "create-discipline";
    }

    @PostMapping("/new")
    public String handleCreateDiscipline(@ModelAttribute CreateDisciplineDto dto, BindingResult bindingResult, Model model){
        Discipline disciplineToCreate = disciplineMapper.fromDto(dto);
        model.addAttribute("CreateDisciplineDto", new CreateDisciplineDto());
        model.addAttribute("teachers", teacherService.getAll());
        if (bindingResult.hasErrors()){
            return "create-discipline";
        }

        disciplineService.create(disciplineToCreate);

        return "redirect:/disciplines";
    }
}
