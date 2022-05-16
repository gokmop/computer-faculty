package com.csdepartment.csdepartment.models.contracts;

import com.csdepartment.csdepartment.models.Teacher;

public interface DisciplineInterface {

    void setDisciplineName(String disciplineName);

    void setCredits(int credits);

    void setTeacher(Teacher teacherId);

    void setStudentsSigned(int studentsCount);

    int getId();

    String getDisciplineName();

    Teacher getTeacher();

    int getStudentSigned();

    int getCreditsForDiscipline();

    String toString();
}
