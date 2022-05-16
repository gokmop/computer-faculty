package com.csdepartment.csdepartment.models;

import com.csdepartment.csdepartment.models.contracts.DisciplineInterface;

import javax.persistence.*;

@Entity(name = "Disciplines")
@Table(name = "disciplines")
public class Discipline implements DisciplineInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk")
    private int id;

    @Column(name = "name")
    private String disciplineName;

    @Column(name = "credits")
    private int credits;

    @Column(name = "teacher-pk")
    private int teacherID;

    @Column(name = "students-signed")
    private int studentsSigned;

    public Discipline() {
    }

    public Discipline(String disciplineName, int credits, int teacherID) {
        this.disciplineName = disciplineName;
        this.credits = credits;
        this.teacherID = teacherID;
        studentsSigned = 0;
    }

    @Override
    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    @Override
    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public void setTeacher(int teacherId) {
        this.teacherID = teacherId;
    }

    @Override
    public void setStudentsSigned(int studentsCount) {
        this.studentsSigned = studentsCount;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDisciplineName() {
        return disciplineName;
    }

    @Override
    public int getTeacherIdForDiscipline() {
        return teacherID;
    }

    @Override
    public int getStudentSigned() {
        return studentsSigned;
    }

    @Override
    public int getCreditsForDiscipline() {
        return credits;
    }
}