package com.csdepartment.csdepartment.repositories;

import com.csdepartment.csdepartment.models.Journal;

import java.util.List;

public interface JournalRepository {

    void create(Journal journal);

    void update(Journal journal);

    void delete(Journal journal);

    Journal getById(int id);

    List<Journal> getAll();

    List<Journal> filterByDisciplineId(int disciplineId);


}


