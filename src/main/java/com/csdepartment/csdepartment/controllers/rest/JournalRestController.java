package com.csdepartment.csdepartment.controllers.rest;

import com.csdepartment.csdepartment.exceptions.DuplicateEntityException;
import com.csdepartment.csdepartment.models.Journal;
import com.csdepartment.csdepartment.models.dto.CreateJournalDto;
import com.csdepartment.csdepartment.models.mappers.JournalMapper;
import com.csdepartment.csdepartment.services.DisciplineService;
import com.csdepartment.csdepartment.services.JournalService;
import com.csdepartment.csdepartment.services.StudentService;
import com.csdepartment.csdepartment.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/journal")
public class JournalRestController {

    private final JournalService journalService;

    private final StudentService studentService;

    private final TeacherService teacherService;

    private final DisciplineService disciplineService;

    private final JournalMapper journalMapper;

    @Autowired
    public JournalRestController(JournalService journalService, StudentService studentService, TeacherService teacherService,
                                 DisciplineService disciplineService, JournalMapper journalMapper) {
        this.journalService = journalService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.disciplineService = disciplineService;
        this.journalMapper = journalMapper;
    }

    @GetMapping
    public List<Journal> getAllJournalRecords(){
        return journalService.getAll();
    }

    @PostMapping
    public Journal create(@RequestBody CreateJournalDto dto){
        try {
            Journal journal = journalMapper.fromDtoCreate(dto);

            return journal;
        }catch (DuplicateEntityException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> removeJournalRecord(@PathVariable int id){
        try {
            journalMapper.fromDtoDelete(id);

            return ResponseEntity.ok("Journal record removed from repository!");
        }catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }



}
