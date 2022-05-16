package com.csdepartment.csdepartment.models;

import com.csdepartment.csdepartment.models.contracts.TeacherInterface;

import javax.persistence.*;

@Entity(name = "Teachers")
@Table(name = "teachers")
public class Teacher implements TeacherInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk")
    private int id;

    @Column(name = "first_name")
    private String firstNameTeach;

    @Column(name = "last_name")
    private String lastNameTeach;

    @Column(name = "title")
    private String title;

    @Column(name = "discipline_count")
    private int disciplineCount;

    @Column(name = "students_count")
    private int studentsCount;

    public Teacher() {
    }

    public Teacher(String firstNameTeach, String lastNameTeach, String title) {
        this.firstNameTeach = firstNameTeach;
        this.lastNameTeach = lastNameTeach;
        this.title = title;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstNameTeach = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastNameTeach = lastName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstNameTeach;
    }

    @Override
    public String getLastName() {
        return lastNameTeach;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setDisciplinesCount(int disciplinesCount) {
        this.disciplineCount = disciplinesCount;
    }


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getDisciplineCount() {
        return disciplineCount;
    }

    @Override
    public String toString(){
        return "Teacher" + "id=" +  id + "Title=" + title + "Name=" + firstNameTeach + " " + lastNameTeach  + "Disciplines count=" + disciplineCount
                + "Students count=" + studentsCount + "}" ;
    }
}
