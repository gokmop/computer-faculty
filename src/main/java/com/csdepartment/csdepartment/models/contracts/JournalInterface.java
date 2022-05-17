package com.csdepartment.csdepartment.models.contracts;

import com.csdepartment.csdepartment.models.Discipline;
import com.csdepartment.csdepartment.models.Student;

public interface JournalInterface {

    void setDiscipline(Discipline discipline);

    Discipline getDiscipline();

    void setStudent(Student student);

    Student getStudent();

    int getId();

    String toString();


}
