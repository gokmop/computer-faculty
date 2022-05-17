package com.csdepartment.csdepartment.models;


import com.csdepartment.csdepartment.models.contracts.StudentInterface;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Students")
@Table(name = "students")
public class Student implements StudentInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
   @Column(name = "year_in_uni")
   private int yearInUni;

   @Column(name= "credits")
   private int credits;

   @Column(name = "count_of_studies")
   private int countStudies;

 //  @OneToMany(mappedBy = "student")
  // private Set<Discipline> studiedDisciplines;

    public Student() {
    }


    public Student(String firstName, String lastName, int yearInUni) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearInUni = yearInUni;
        credits = 0;
        countStudies = 0;
       // studiedDisciplines = new HashSet<>();
    }



    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setYearInUni(int yearInUni) {
        this.yearInUni = yearInUni;
    }

    @Override
    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public void setCountStudies(int countStudies) {
        this.countStudies = countStudies;
    }

    @Override
    public int getYearInUni() {
        return yearInUni;
    }

    @Override
    public int getCredits() {
        return credits;
    }

    @Override
    public int getCountStudies() {
        return countStudies;
    }

    @Override
    public String toString(){
        return "Student" + "id=" + id + "Name=" + firstName + " " + lastName + "Year in university=" + yearInUni
                + "Credits=" + credits + "Count of Studies=" + countStudies+ "}" ;
    }
}
