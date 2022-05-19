package com.csdepartment.csdepartment.services;

import com.csdepartment.csdepartment.models.Journal;
import com.csdepartment.csdepartment.models.dto.CreateJournalDto;

import java.util.List;

public interface JournalService {

    void create(Journal journal);

    void update(Journal journal);

    void delete(Journal journal);

    Journal getById(int id);

    List<Journal> getAll();

    List<Journal> filterByDisciplineId(int disciplineId);

    List<Journal> filterByStudentId(int studentId);

    public Boolean recordDontExist(CreateJournalDto dto);

}
