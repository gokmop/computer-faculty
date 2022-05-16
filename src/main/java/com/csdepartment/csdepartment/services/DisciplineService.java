package com.csdepartment.csdepartment.services;

import com.csdepartment.csdepartment.models.Discipline;

import java.util.List;

public interface DisciplineService {

    Discipline getById(int id);

    List<Discipline> getAll();

    List<Discipline> filterByName(String name);

    List<Discipline> sortByStudentsSigned();

    List<Discipline> sortByCredits();

    List<Discipline> sortByTeacher();

    List<Discipline> top3Disciplines();

}
