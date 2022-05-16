package com.csdepartment.csdepartment.models.mappers;

import com.csdepartment.csdepartment.models.CreateDisciplineDto;
import com.csdepartment.csdepartment.models.Discipline;
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
        return discipline;
    }
}
