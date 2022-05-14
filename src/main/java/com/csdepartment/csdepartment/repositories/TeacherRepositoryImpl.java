package com.csdepartment.csdepartment.repositories;

import com.csdepartment.csdepartment.models.Student;
import com.csdepartment.csdepartment.models.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository{

    private final SessionFactory sessionFactory;

    @Autowired
    public TeacherRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Teacher teacher) {
        try(Session session = sessionFactory.openSession()){
            session.save(teacher);
        }
    }

    @Override
    public void update(Teacher teacher) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.update(teacher);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Teacher teacher) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(teacher);
            session.getTransaction().commit();
        }
    }

    @Override
    public Teacher getById(int id) {
        try (Session session = sessionFactory.openSession()){
            Teacher teacher = session.get(Teacher.class, id);
            if (teacher == null){
                throw new EntityNotFoundException(
                        String.format("Teacher with id %d not found!", id));
            }
            return teacher;
        }
    }

    @Override
    public List<Teacher> getAll() {
        try (Session session = sessionFactory.openSession()){
            Query<Teacher> query = session.createQuery("from Teachers order by firstNameTeach");
            return query.list();
        }
    }

    @Override
    public List<Teacher> filterByFirstName(String name) {
        if (name.isEmpty()){
            return getAll();
        }

        try (Session session = sessionFactory.openSession()){

            String hql = "FROM Teachers S WHERE S.firstNameTeach = :firstName";
            Query query = session.createQuery(hql);
            query.setParameter("firstName", name);
            List results = query.list();

            return results;

        }
    }

    @Override
    public List<Teacher> sortByDisciplines() {
        try (Session session = sessionFactory.openSession()){
            Query<Teacher> query = session.createQuery("from Teachers order by disciplineCount desc");
            return query.list();
        }
    }

    @Override
    public List<Teacher> sortByFirstName() {
        try (Session session = sessionFactory.openSession()){
            Query<Teacher> query = session.createQuery("from Teachers order by firstNameTeach asc");
            return query.list();
        }
    }

    @Override
    public List<Teacher> sortByLastName() {
        try (Session session = sessionFactory.openSession()){
            Query<Teacher> query = session.createQuery("from Teachers order by lastNameTeach");
            return query.list();
        }
    }

    @Override
    public List<Teacher> sortByStudents() {
        try (Session session = sessionFactory.openSession()){
            Query<Teacher> query = session.createQuery("from Teachers order by studentsCount desc ");
            return query.list();
        }
    }

    @Override
    public List<Teacher> top3Teachers() {
        try (Session session = sessionFactory.openSession()){
            Query<Teacher> query = session.createQuery("from Teachers order by disciplineCount desc");
            return query.setMaxResults(3).list();
        }
    }
}
