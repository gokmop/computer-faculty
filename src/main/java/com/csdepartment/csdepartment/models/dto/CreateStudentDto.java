package com.csdepartment.csdepartment.models.dto;

public class CreateStudentDto {

    private String firstName;

    private String lastName;

    private int yearInUni;

    public CreateStudentDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearInUni() {
        return yearInUni;
    }

    public void setYearInUni(int yearInUni) {
        this.yearInUni = yearInUni;
    }
}
