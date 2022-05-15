package com.csdepartment.csdepartment.controllers.rest;

import com.csdepartment.csdepartment.exceptions.DuplicateEntityException;
import com.csdepartment.csdepartment.models.Teacher;
import com.csdepartment.csdepartment.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherRestController {

    private final TeacherService service;

    @Autowired
    public TeacherRestController(TeacherService service) {
        this.service = service;
    }

    @GetMapping
    public List<Teacher> getAllTeachers(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Teacher getById(@PathVariable int id){
        try {
            return service.getById(id);
        } catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    public Teacher create(@RequestBody Teacher teacher){
        try{
            service.create(teacher);
            return teacher;
        }catch (DuplicateEntityException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PutMapping
    public Teacher update(@RequestBody Teacher teacher){
        service.update(teacher);
        return teacher;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> removeStudent(@PathVariable int id){
        try {
            service.delete(getById(id));
            return ResponseEntity.ok("Teacher successfully removed from repository!");
        }catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/last-name")
    public List<Teacher> sortByLastName(){
        return service.sortByLastName();
    }

    @GetMapping("/students")
    public List<Teacher> sortByStudents(){
        return service.sortByStudents();
    }

    @GetMapping("/disciplines")
    public List<Teacher> sortByDisciplines(){
        return service.sortByDisciplines();
    }

    @GetMapping("/first-name")
    public List<Teacher> sortByFirstName(){
        return service.sortByFirstName();
    }

    @GetMapping("filter-by-firstName")
    public List<Teacher> searchBy(@RequestParam(required = false) String firstName) {

        if (firstName!=null) {
            return service.filterByFirstName(firstName);
        } else {
            return getAllTeachers();
        }
    }

    @GetMapping("/top3")
    public List<Teacher> top3Teachers(){
        return service.top3Teachers();
    }

}
