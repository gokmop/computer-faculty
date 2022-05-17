package com.csdepartment.csdepartment.models.contracts;

public interface TeacherInterface {

    void setFirstName(String firstName);

    void setLastName(String lastName);

    int getId();

    String getFirstName();

    String getLastName();

    void setTitle(String title);

    void setDisciplinesCount(int disciplinesCount);

    String getTitle();

    int getDisciplineCount();

    String toString();

    void setStudentsCount(int studentsCount);

    int getStudentsCount();

}
