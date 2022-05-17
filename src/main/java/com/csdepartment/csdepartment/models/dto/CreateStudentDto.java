package com.csdepartment.csdepartment.models.dto;

import org.springframework.context.annotation.Scope;

import javax.validation.constraints.*;

@Scope("prototype")
public class CreateStudentDto {

    @NotBlank
    @Size(min = 2, max = 20, message = "Name should be between 2 & 20 symbols")
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 20, message = "Name should be between 2 & 20 symbols")
    private String lastName;

    @Positive
    @Min(value = 1, message = "First year is the minimum")
    @Max(value = 4, message = "Fourth year is the last year")
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
