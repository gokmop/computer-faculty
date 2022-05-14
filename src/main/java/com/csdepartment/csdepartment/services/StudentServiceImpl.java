package com.csdepartment.csdepartment.services;

import com.csdepartment.csdepartment.models.Student;
import com.csdepartment.csdepartment.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }



    @Override
    public int getCredits() {
        return 0;
    }

    @Override
    public int getCountStudies() {
        return 0;
    }

    @Override
    public void create(Student student) {
        repository.create(student);
    }

    @Override
    public void update(Student student) {
        repository.update(student);
    }

    @Override
    public void delete(Student student) {
        repository.delete(student);
    }

    @Override
    public Student getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Student> getAll() {
        return repository.getAll();
    }


    @Override
    public List<Student> filterByName(String name) {
        return repository.filterByName(name);
    }

    @Override
    public List<Student> sortByCredits() {
        return repository.sortByCredits();
    }

    @Override
    public List<Student> sortByFirstName() {
        return repository.sortByFirstName();
    }

    @Override
    public List<Student> sortByLastName() {
        return repository.sortByLastName();
    }

    @Override
    public List<Student> filterByYearInUni(int yearInUni) {
        return repository.filterByYearInUni(yearInUni);
    }

    @Override
    public List<Student> sortByYearInUni() {
        return repository.sortByYearInUni();
    }

    @Override
    public List<Student> top3Students() {
        return repository.top3Students();
    }
}
