package com.csdepartment.csdepartment.services;

import com.csdepartment.csdepartment.models.Teacher;
import com.csdepartment.csdepartment.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository repository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }


    @Override
    public void create(Teacher teacher) {
        repository.create(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        repository.update(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        repository.delete(teacher);
    }

    @Override
    public Teacher getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Teacher> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Teacher> filterByFirstName(String name) {
        return repository.filterByFirstName(name);
    }

    @Override
    public List<Teacher> sortByDisciplines() {
        return repository.sortByDisciplines();
    }

    @Override
    public List<Teacher> sortByFirstName() {
        return repository.sortByFirstName();
    }

    @Override
    public List<Teacher> sortByLastName() {
        return repository.sortByLastName();
    }

    @Override
    public List<Teacher> sortByStudents() {
        return repository.sortByStudents();
    }

    @Override
    public List<Teacher> top3Teachers() {
        return repository.top3Teachers();
    }
}
