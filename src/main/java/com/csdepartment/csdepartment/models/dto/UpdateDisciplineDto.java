package com.csdepartment.csdepartment.models.dto;

import org.springframework.stereotype.Component;


public class UpdateDisciplineDto {

    private int id;

    private String disciplineName;

    private int credits;

    private int teacherId;

    private int countStudentsSigned;

    public UpdateDisciplineDto() {
    }

    public int getId() {
        return id;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public int getCredits() {
        return credits;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getCountStudentsSigned() {
        return countStudentsSigned;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setCountStudentsSigned(int countStudentsSigned) {
        this.countStudentsSigned = countStudentsSigned;
    }
}
