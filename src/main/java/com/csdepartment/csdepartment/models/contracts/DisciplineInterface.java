package com.csdepartment.csdepartment.models.contracts;

public interface DisciplineInterface {

    void setDisciplineName(String disciplineName);

    void setCredits(int credits);

    void setTeacher(int teacherId);

    void setStudentsSigned(int studentsCount);

    int getId();

    String getDisciplineName();

    int getTeacherIdForDiscipline();

    int getStudentSigned();

    int getCreditsForDiscipline();

    String toString();
}
