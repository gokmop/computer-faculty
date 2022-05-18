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

    @ManyToOne
    @JoinColumn(name = "teacher_pk")
    private Teacher teacher;

    @Column(name = "students_signed")
    private int studentsSigned;



    public Discipline() {
    }

    public Discipline(String disciplineName, int credits, Teacher teacher) {
        this.disciplineName = disciplineName;
        this.credits = credits;
        this.teacher = teacher;
        //signedStudents = new HashSet<>();

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
    public void setTeacher(Teacher teacherId) {
        this.teacher = teacherId;
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
    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public int getStudentSigned() {
        return studentsSigned;
    }

    @Override
    public int getCreditsForDiscipline() {
        return credits;
    }

    @Override
    public String toString(){
        return "Discipline" + "id=" + id + "Name=" + disciplineName  + "Credits=" + credits
                + "Teacher Id=" + teacher.getId() + "Students Signed=" + studentsSigned+ "}" ;
    }
}
