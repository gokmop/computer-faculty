package com.csdepartment.csdepartment.models;

import com.csdepartment.csdepartment.models.contracts.JournalInterface;

import javax.persistence.*;

@Entity(name = "Journal")
@Table(name = "journal")
public class Journal implements JournalInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "discipline-fk")
    private Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "student-fk")
    private Student student;

    public Journal() {
    }

    public Journal(Discipline discipline, Student student) {
        this.discipline = discipline;
        this.student = student;
    }

    @Override
    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public Discipline getDiscipline() {
        return discipline;
    }

    @Override
    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public Student getStudent() {
        return student;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return "Discipline = " + discipline + "Student = " + student;
    }
}
