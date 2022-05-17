package com.csdepartment.csdepartment.models.dto;

public class CreateDisciplineDto {

    private String disciplineName;

    private int credits;

    private int teacherId;

    public CreateDisciplineDto() {
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

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
