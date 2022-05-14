package com.csdepartment.csdepartment.repositories;

import com.csdepartment.csdepartment.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    void create(Student student);

    void update(Student student);

    void delete(Student student);

    Student getById(int id);

    List<Student> getAll();

    List<Student> filterByName(String name);

    List<Student> sortByCredits();

    List<Student> sortByFirstName();

    List<Student> sortByLastName();

    List<Student> filterByYearInUni(int yearInUni);

    List<Student> sortByYearInUni();

    List<Student> top3Students();

    int getCredits(int id);

    int getCountStudies(int id);

}
