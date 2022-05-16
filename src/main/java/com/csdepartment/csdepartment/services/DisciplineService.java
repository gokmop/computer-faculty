package com.csdepartment.csdepartment.services;

import com.csdepartment.csdepartment.models.Discipline;

import java.util.List;

public interface DisciplineService {

    void create(Discipline discipline);

    void update(Discipline discipline);

    void delete(Discipline discipline);


    Discipline getById(int id);

    List<Discipline> getAll();

    List<Discipline> filterByName(String name);

    List<Discipline> sortByStudentsSigned();

    List<Discipline> sortByCredits();

    List<Discipline> sortByTeacher();

    List<Discipline> top3Disciplines();

}
