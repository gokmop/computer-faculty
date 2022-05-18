package com.csdepartment.csdepartment.services;

import com.csdepartment.csdepartment.models.Journal;
import com.csdepartment.csdepartment.repositories.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalServiceImpl implements JournalService {

    private final JournalRepository repository;

    @Autowired
    public JournalServiceImpl(JournalRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Journal journal) {
        repository.create(journal);
    }

    @Override
    public void update(Journal journal) {
        repository.update(journal);
    }

    @Override
    public void delete(Journal journal) {
        repository.delete(journal);
    }

    @Override
    public Journal getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Journal> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Journal> filterByDisciplineId(int disciplineId) {
        return repository.filterByDisciplineId(disciplineId);
    }

    @Override
    public List<Journal> filterByStudentId(int studentId) {
        return repository.filterByStudentId(studentId);
    }


}
