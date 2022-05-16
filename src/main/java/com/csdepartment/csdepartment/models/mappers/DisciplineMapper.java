package com.csdepartment.csdepartment.models.mappers;

import com.csdepartment.csdepartment.models.CreateDisciplineDto;
import com.csdepartment.csdepartment.models.Discipline;
import com.csdepartment.csdepartment.models.Teacher;
import com.csdepartment.csdepartment.models.UpdateDisciplineDto;
import com.csdepartment.csdepartment.services.DisciplineService;
import com.csdepartment.csdepartment.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DisciplineMapper {

    private final TeacherService teacherService;

    private final DisciplineService disciplineService;

    @Autowired
    public DisciplineMapper(TeacherService teacherService, DisciplineService disciplineService) {
        this.teacherService = teacherService;
        this.disciplineService = disciplineService;
    }

    public Discipline fromDto(CreateDisciplineDto dto){
        Discipline discipline = new Discipline();
        discipline.setDisciplineName(dto.getDisciplineName());
        discipline.setCredits(dto.getCredits());
        discipline.setTeacher(teacherService.getById(dto.getTeacherId()));
        int incrementDisciplinesOfTeacher = teacherService.getById(dto.getTeacherId()).getDisciplineCount() + 1;
        Teacher teacher =  teacherService.getById(dto.getTeacherId());
        teacher.setDisciplinesCount(incrementDisciplinesOfTeacher);
        teacherService.update(teacher);
        return discipline;
    }

    public Discipline fromUpdateDto(UpdateDisciplineDto dto){
        Discipline discipline = disciplineService.getById(dto.getId());
        Teacher teacher = teacherService.getById(dto.getTeacherId());
        discipline.setDisciplineName(dto.getDisciplineName());
        if (teacher != discipline.getTeacher()){
            Teacher oldTeacher = discipline.getTeacher();
            int disciplinesCountOldTeacher = teacher.getDisciplineCount();
            oldTeacher.setDisciplinesCount(disciplinesCountOldTeacher - 1);
            teacherService.update(oldTeacher);
            discipline.setTeacher(teacher);
        }

        discipline.setCredits(dto.getCredits());
        discipline.setStudentsSigned(dto.getCountStudentsSigned());
        disciplineService.update(discipline);

        return discipline;

    }
}
