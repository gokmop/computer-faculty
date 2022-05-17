package com.csdepartment.csdepartment.services;

import com.csdepartment.csdepartment.models.Teacher;

import java.util.List;

public interface TeacherService {
    void create(Teacher teacher);

    void update(Teacher teacher);

    void delete(Teacher teacher);

    Teacher getById(int id);

    List<Teacher> getAll();

    List<Teacher> filterByFirstName(String name);

    List<Teacher> sortByDisciplines();

    List<Teacher> sortByFirstName();

    List<Teacher> sortByLastName();

    List<Teacher> sortByStudents();

    List<Teacher> top3Teachers();

    int getStudentsCount(int id);

    int getStudiesCount(int id);
}
