package com.csdepartment.csdepartment.models.mappers;

import com.csdepartment.csdepartment.models.Teacher;
import com.csdepartment.csdepartment.models.dto.CreateTeacherDto;
import com.csdepartment.csdepartment.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    private final TeacherService teacherService;

    @Autowired
    public TeacherMapper(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public Teacher fromDto(CreateTeacherDto dto){
        Teacher teacher = new Teacher();
        teacher.setFirstName(dto.getFirstName());
        teacher.setLastName(dto.getLastName());
        teacher.setTitle(dto.getTitle());
        teacherService.create(teacher);
        return teacher;
    }
}
