package com.csdepartment.csdepartment.services;

import com.csdepartment.csdepartment.models.Journal;

import java.util.List;

public interface JournalService {

    void create(Journal journal);

    void update(Journal journal);

    void delete(Journal journal);

    Journal getById(int id);

    List<Journal> getAll();

    List<Journal> filterByDisciplineId(int disciplineId);

}
