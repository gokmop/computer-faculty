package com.csdepartment.csdepartment.controllers.rest;

import com.csdepartment.csdepartment.exceptions.DuplicateEntityException;
import com.csdepartment.csdepartment.models.Student;
import com.csdepartment.csdepartment.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    private final StudentService service;

    @Autowired
    public StudentRestController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id){
        try {
            return service.getById(id);
        } catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    public Student create(@RequestBody Student student){
        try{
            service.create(student);
            return student;
        }catch (DuplicateEntityException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    //Not working properly
    @GetMapping("search")
    public List<Student> search(@RequestParam(required = false) String firstName,
                                @RequestParam(required = false) String lastName,
                                @RequestParam(required = false) Integer id){

            if (firstName != null && !firstName.isBlank()){
                return service.filterByName(firstName);
            } else if (lastName != null && !lastName.isBlank()) {
                return service.filterByName(lastName);
            } else if (id > 0) {
                return (List<Student>) service.getById(id);
            }else return new ArrayList<>();


   }

    @GetMapping("filter-by-year")
    public List<Student> searchByYearInUni(@RequestParam(required = false) int yearInUni) {

        if (yearInUni != 0) {
            return service.filterByYearInUni(yearInUni);
        } else {
            return getAll();
        }
    }

    @PutMapping
    public Student update(@RequestBody Student student){

            service.update(student);
      return student;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> removeStudent(@PathVariable int id){
        try{
            service.delete(getById(id));
            return ResponseEntity.ok("Student successfully removed from repository!");
        }catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }


    @GetMapping("/last-name")
    public List<Student> sortByLastName(){
        return service.sortByLastName();
    }

    @GetMapping("/credits")
    public List<Student> sortByCredits(){
        return service.sortByCredits();
    }

    @GetMapping("/top3")
    public List<Student> top3Students(){
        return service.top3Students();
    }
}
