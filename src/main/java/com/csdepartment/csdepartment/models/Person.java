package com.csdepartment.csdepartment.models;

import com.csdepartment.csdepartment.models.contracts.PersonInterface;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@MappedSuperclass
public abstract class Person implements PersonInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Autowired


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
    public String toString(){
        return "Person{" + "id=" + id + "Name=" + firstName + " " + lastName + "}";
    }
}
