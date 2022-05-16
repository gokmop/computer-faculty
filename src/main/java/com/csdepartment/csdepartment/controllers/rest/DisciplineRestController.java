package com.csdepartment.csdepartment.controllers.rest;

import com.csdepartment.csdepartment.exceptions.DuplicateEntityException;
import com.csdepartment.csdepartment.models.CreateDisciplineDto;
import com.csdepartment.csdepartment.models.Discipline;
import com.csdepartment.csdepartment.models.mappers.DisciplineMapper;
import com.csdepartment.csdepartment.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineRestController {

    private final DisciplineService service;
    private final DisciplineMapper mapper;

    @Autowired
    public DisciplineRestController(DisciplineService service, DisciplineMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<Discipline> getAllDisciplines(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Discipline getById(@PathVariable int id){
        try {
            return service.getById(id);
        }catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    public Discipline create(@RequestBody CreateDisciplineDto dto){
        try{
            Discipline discipline = mapper.fromDto(dto);
            service.create(discipline);
            return discipline;
        }catch (DuplicateEntityException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PutMapping
    public Discipline update(@RequestBody Discipline discipline){
        service.update(discipline);
        return discipline;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> removeDiscipline(@PathVariable int id){
        try {
            service.delete(getById(id));
            return ResponseEntity.ok("Discipline successfully removed from repository!");
        }catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/filter-by-name")
    public List<Discipline> sortByLastName(@RequestParam(required = false) String name){
        if (name != null){
            return service.filterByName(name);
        }else {
            return getAllDisciplines();
        }
    }

    @GetMapping("/top3")
    public List<Discipline> top3Disciplines(){
        return service.top3Disciplines();
    }

    @GetMapping("/teacher")
    public List<Discipline> sortByTeacher(){
        return service.sortByTeacher();
    }

    @GetMapping("/students")
    public List<Discipline> sortByStudents(){
        return service.sortByStudentsSigned();
    }

    @GetMapping("/credits")
    public List<Discipline> sortByCredits(){
        return service.sortByCredits();
    }
}
