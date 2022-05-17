package com.csdepartment.csdepartment.models.dto;

public class CreateJournalDto {

    private int disciplineId;

    private int studentId;

    public CreateJournalDto() {
    }

    public int getDisciplineId() {
        return disciplineId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
