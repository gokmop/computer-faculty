package com.csdepartment.csdepartment.repositories;

import com.csdepartment.csdepartment.models.Journal;
import com.csdepartment.csdepartment.models.dto.CreateJournalDto;
import com.csdepartment.csdepartment.services.DisciplineService;
import com.csdepartment.csdepartment.services.StudentService;
import com.csdepartment.csdepartment.services.TeacherService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Repository
public class JournalRepositoryImpl implements JournalRepository{

   private final SessionFactory sessionFactory;

   private final StudentService studentService;

   private final DisciplineService disciplineService;

   private final TeacherService teacherService;

   @Autowired
    public JournalRepositoryImpl(SessionFactory sessionFactory, StudentService studentService, DisciplineService disciplineService, TeacherService teacherService) {
        this.sessionFactory = sessionFactory;
        this.studentService = studentService;
        this.disciplineService = disciplineService;
        this.teacherService = teacherService;
    }

    @Override
    public void create(Journal journal) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(journal);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Journal journal) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.update(journal);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Journal journal) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(journal);
            session.getTransaction().commit();
        }
    }

    @Override
    public Journal getById(int id) {
        try (Session session = sessionFactory.openSession()){
            Journal journal = session.get(Journal.class, id);
            if (journal == null){
                throw new EntityNotFoundException(
                        String.format("Journal record with id %d not found!", id));
            }
            return journal;
        }
    }

    @Override
    public List<Journal> getAll() {
        try (Session session = sessionFactory.openSession()){
            Query<Journal> query = session.createQuery("from Journal");
            return query.getResultList();
        }
    }

    @Override
    public List<Journal> filterByDisciplineId(int disciplineId) {
        try (Session session = sessionFactory.openSession()){
            Query<Journal> query = session.createQuery("from Journal where discipline.id = :disciplineId");
            query.setParameter("disciplineId", disciplineId);
            return query.list();
        }
    }

    @Override
    public List<Journal> filterByStudentId(int studentId) {
        try(Session session = sessionFactory.openSession()){
            Query<Journal> query = session.createQuery("from Journal where student.id = :studentId");
            query.setParameter("studentId", studentId);
            return query.list();
        }
    }

    @Override
    public Boolean recordDontExist(CreateJournalDto dto) {
        try(Session session = sessionFactory.openSession()){
            Query<Journal> query = session.createQuery("from Journal where student.id = :studentId and discipline.id = :disciplineId");
            query.setParameter("studentId", dto.getStudentId());
            query.setParameter("disciplineId", dto.getDisciplineId());
            Boolean recordDoNotExists = query.list().isEmpty();
            return recordDoNotExists;
        }
    }
}
