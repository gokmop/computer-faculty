package com.csdepartment.csdepartment.models.dto;

import org.springframework.context.annotation.Scope;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Scope("prototype")
public class CreateTeacherDto {

    @NotBlank
    @Size(min = 2, max = 20, message = "Name should be between 2 & 20 symbols")
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 20, message = "Name should be between 2 & 20 symbols")
    private String lastName;

    @NotBlank
    @Size(min = 2, max = 40, message = "Name should be between 2 & 40 symbols")
    private String title;

    public CreateTeacherDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
