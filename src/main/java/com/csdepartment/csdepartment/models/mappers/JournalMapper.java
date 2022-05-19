package com.csdepartment.csdepartment.models.mappers;

import com.csdepartment.csdepartment.models.Discipline;
import com.csdepartment.csdepartment.models.Journal;
import com.csdepartment.csdepartment.models.Student;
import com.csdepartment.csdepartment.models.Teacher;
import com.csdepartment.csdepartment.models.dto.CreateJournalDto;
import com.csdepartment.csdepartment.services.DisciplineService;
import com.csdepartment.csdepartment.services.JournalService;
import com.csdepartment.csdepartment.services.StudentService;
import com.csdepartment.csdepartment.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JournalMapper {

    private final StudentService studentService;

    private final DisciplineService disciplineService;

    private final TeacherService teacherService;

    private final JournalService journalService;

    @Autowired
    public JournalMapper(StudentService studentService, DisciplineService disciplineService, TeacherService teacherService, JournalService journalService) {
        this.studentService = studentService;
        this.disciplineService = disciplineService;
        this.teacherService = teacherService;
        this.journalService = journalService;
    }

    public Journal fromDtoCreate(CreateJournalDto dto){
        Journal journal = new Journal();
        Discipline discipline = disciplineService.getById(dto.getDisciplineId());
        Student student = studentService.getById(dto.getStudentId());
        Teacher teacher = discipline.getTeacher();
        journal.setDiscipline(discipline);
        journal.setStudent(student);
        student.setCredits(student.getCredits() + discipline.getCreditsForDiscipline());
        student.setCountStudies(student.getCountStudies() + 1);
        discipline.setStudentsSigned(discipline.getStudentSigned() + 1);
        teacher.setStudentsCount(teacher.getStudentsCount() + 1);
        teacherService.update(teacher);
        studentService.update(student);
        disciplineService.update(discipline);

        return journal;
    }

    public String fromDtoDelete(int journalRecordId){
        Journal journal = journalService.getById(journalRecordId);
        Discipline discipline = journal.getDiscipline();
        Student student = journal.getStudent();
        Teacher teacher = discipline.getTeacher();
        journalService.delete(journal);
        discipline.setStudentsSigned(discipline.getStudentSigned() - 1);
        teacher.setStudentsCount(teacher.getStudentsCount() - 1);
        student.setCredits(student.getCredits() - discipline.getCreditsForDiscipline());
        student.setCountStudies(student.getCountStudies() - 1);
        disciplineService.update(discipline);
        studentService.update(student);
        teacherService.update(teacher);
        return "Journal successfully deleted";
    }
}
