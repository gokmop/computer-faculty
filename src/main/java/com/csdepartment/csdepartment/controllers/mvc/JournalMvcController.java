package com.csdepartment.csdepartment.controllers.mvc;

import com.csdepartment.csdepartment.models.Journal;
import com.csdepartment.csdepartment.models.dto.CreateJournalDto;
import com.csdepartment.csdepartment.models.mappers.JournalMapper;
import com.csdepartment.csdepartment.services.DisciplineService;
import com.csdepartment.csdepartment.services.JournalService;
import com.csdepartment.csdepartment.services.StudentService;
import com.csdepartment.csdepartment.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/journal")
public class JournalMvcController {

    private final JournalService journalService;

    private final StudentService studentService;

    private final DisciplineService disciplineService;

    private final TeacherService teacherService;

    private final JournalMapper journalMapper;

    @Autowired
    public JournalMvcController(JournalService journalService, StudentService studentService, DisciplineService disciplineService, TeacherService teacherService, JournalMapper journalMapper) {
        this.journalService = journalService;
        this.studentService = studentService;
        this.disciplineService = disciplineService;
        this.teacherService = teacherService;
        this.journalMapper = journalMapper;
    }

    @GetMapping
    public String showAllJournalRecords(Model model){
        model.addAttribute("journalRecords", journalService.getAll());
        return "journal-show-all";
    }

    @GetMapping("/new")
    private String handleCreateJournalPage(Model model){
        model.addAttribute("CreateJournalDto", new CreateJournalDto());
        model.addAttribute("disciplines", disciplineService.getAll());
        model.addAttribute("students", studentService.getAll());
        return "create-journal-record";
    }

    @PostMapping("/new")
    private String handleCreateJournalRecord(@ModelAttribute CreateJournalDto dto, BindingResult bindingResult,
                                             Model model){
        Journal journalToCreate = journalMapper.fromDtoCreate(dto);
        model.addAttribute("CreateJournalDto", new CreateJournalDto());
        model.addAttribute("disciplines", disciplineService.getAll());
        model.addAttribute("students", studentService.getAll());
        if (bindingResult.hasErrors()){
            return "create-journal-record";
        }
        if (journalService.recordDontExist(dto)){
            journalService.create(journalToCreate);
            return "redirect:/journal";
        }else return "create-journal-record";

    }
    @GetMapping("/delete")
    private String handleDeleteJournalPage(Model model){
        model.addAttribute("journals", journalService.getAll());
        model.addAttribute("disciplines", disciplineService.getAll());
        model.addAttribute("students", studentService.getAll());
        return "delete-journal-record";
    }
    @RequestMapping("/delete/{id}")
    public String handleDeleteJournalRecord(@PathVariable int id, Model model){
        journalMapper.fromDtoDelete(id);
        model.addAttribute("journal", journalService.getAll());
        model.addAttribute("disciplines", disciplineService.getAll());
        model.addAttribute("students", studentService.getAll());

        return "redirect:/journal";
    }
}
