package com.csdepartment.csdepartment.services;

import com.csdepartment.csdepartment.models.Discipline;
import com.csdepartment.csdepartment.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService{

    private final DisciplineRepository repository;

    @Autowired
    public DisciplineServiceImpl(DisciplineRepository repository) {
        this.repository = repository;
    }

    @Override
    public Discipline getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Discipline> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Discipline> filterByName(String name) {
        return repository.filterByName(name);
    }

    @Override
    public List<Discipline> sortByStudentsSigned() {
        return repository.sortByStudentsSigned();
    }

    @Override
    public List<Discipline> sortByCredits() {
        return repository.sortByCredits();
    }

    @Override
    public List<Discipline> sortByTeacher() {
        return repository.sortByTeacher();
    }

    @Override
    public List<Discipline> top3Disciplines() {
        return repository.top3Disciplines();
    }
}
