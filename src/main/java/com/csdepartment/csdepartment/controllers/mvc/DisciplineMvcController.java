package com.csdepartment.csdepartment.controllers.mvc;

import com.csdepartment.csdepartment.models.mappers.DisciplineMapper;
import com.csdepartment.csdepartment.services.DisciplineService;
import com.csdepartment.csdepartment.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
