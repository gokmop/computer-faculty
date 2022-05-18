package com.csdepartment.csdepartment.repositories;

import com.csdepartment.csdepartment.models.Discipline;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Repository
public class DisciplineRepositoryImpl implements DisciplineRepository{

    private final SessionFactory sessionFactory;


    @Autowired
    public DisciplineRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void create(Discipline discipline) {
        try(Session session = sessionFactory.openSession()){

            session.save(discipline);
        }
    }

    @Override
    public void update(Discipline discipline) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.update(discipline);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Discipline discipline) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(discipline);
            session.getTransaction().commit();
        }
    }

    @Override
    public Discipline getById(int id) {
        try (Session session = sessionFactory.openSession()){
            Discipline discipline = session.get(Discipline.class, id);
            if (discipline == null){
                throw new EntityNotFoundException(
                        String.format("Discipline with id %d not found!", id));
            }
            return discipline;
        }
    }

    @Override
    public List<Discipline> getAll() {
        try (Session session = sessionFactory.openSession()){
            Query<Discipline> query = session.createQuery("from Disciplines");
            return query.list();
        }
    }

    @Override
    public List<Discipline> filterByName(String name) {
        if (name.isEmpty()){
            return getAll();
        }

        try (Session session = sessionFactory.openSession()){

            String hql = "FROM Disciplines D WHERE D.disciplineName = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name",name);
            List results = query.list();

            return results;

        }
    }

    @Override
    public List<Discipline> sortByStudentsSigned() {
        try (Session session = sessionFactory.openSession()){
            Query<Discipline> query = session.createQuery("from Disciplines order by studentsSigned desc ");
            return query.list();
        }
    }

    @Override
    public List<Discipline> sortByCredits() {
        try (Session session = sessionFactory.openSession()){
            Query<Discipline> query = session.createQuery("from Disciplines order by credits desc ");
            return query.list();
        }
    }

    @Override
    public List<Discipline> sortByTeacher() {
        try (Session session = sessionFactory.openSession()){
            Query<Discipline> query = session.createQuery("from Disciplines order by teacher.firstNameTeach asc ");
            return query.list();
        }
    }

    @Override
    public List<Discipline> top3Disciplines() {
        try (Session session = sessionFactory.openSession()){
            Query<Discipline> query = session.createQuery("from Disciplines order by studentsSigned desc");
            return query.setMaxResults(3).list();
        }
    }

    @Override
    public List<Discipline> filterByTeacherId(int teacherId) {
        try(Session session = sessionFactory.openSession()){
            Query<Discipline> query = session.createQuery("from Disciplines where teacher.id = :teacherId");
            query.setParameter("teacherId", teacherId);
            return query.list();
        }
    }
}
