package com.csdepartment.csdepartment.repositories;

import com.csdepartment.csdepartment.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityNotFoundException;
import java.util.List;


@Repository
public class StudentRepositoryImpl implements StudentRepository{

    private final SessionFactory sessionFactory;

    @Autowired
    public StudentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void create(Student student) {
        try(Session session = sessionFactory.openSession()){
            session.save(student);
        }
    }

    @Override
    public void update(Student student) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Student student) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public Student getById(int id) {
        try (Session session = sessionFactory.openSession()){
            Student student = session.get(Student.class, id);
            if (student == null){
                throw new EntityNotFoundException(
                        String.format("Student with id %d not found!", id));
            }
            return student;
        }
    }

    @Override
    public List<Student> getAll() {
        try (Session session = sessionFactory.openSession()){
            Query<Student> query = session.createQuery("from Students order by firstName");
            return query.list();
        }
    }

    @Override
    public List<Student> filterByName(String firstName) {

        if (firstName.isEmpty()){
            return getAll();
        }

        try (Session session = sessionFactory.openSession()){

            String hql = "FROM Students S WHERE S.firstName = :firstName";
            Query query = session.createQuery(hql);
            query.setParameter("firstName",firstName);
            List results = query.list();

            return results;

        }
    }

    @Override
    public List<Student> sortByCredits() {
        try (Session session = sessionFactory.openSession()){
            Query<Student> query = session.createQuery("from Students order by credits desc");
            return query.list();
        }
    }

    @Override
    public List<Student> sortByFirstName() {
        try (Session session = sessionFactory.openSession()){
            Query<Student> query = session.createQuery("from Students order by firstName asc");
            return query.list();
        }
    }

    @Override
    public List<Student> sortByLastName() {
        try (Session session = sessionFactory.openSession()){
            Query<Student> query = session.createQuery("from Students order by lastName");
            return query.list();
        }
    }


    @Override
    public List<Student> filterByYearInUni(int yearInUniv) {
       if (yearInUniv <=0 || yearInUniv >= 5){
         return getAll();
      }

    try (Session session = sessionFactory.openSession()){

            String hql = "FROM Students S WHERE S.yearInUni = :yearInUniv";
            Query query = session.createQuery(hql);
            query.setParameter("yearInUniv",yearInUniv);
            List results = query.list();

            return results;

        }
    }

    @Override
    public List<Student> sortByYearInUni() {
        try (Session session = sessionFactory.openSession()){
            Query<Student> query = session.createQuery("from Students order by yearInUni asc");

            return query.list();
        }
    }

    @Override
    public List<Student> top3Students() {
        try (Session session = sessionFactory.openSession()){
            Query<Student> query = session.createQuery("from Students order by credits desc");
            return query.setMaxResults(3).list();
        }
    }

    @Override
    public int getCredits(int id) {
        try (Session session = sessionFactory.openSession()){
            Student student = getById(id);
            return student.getCredits();
        }
    }

    @Override
    public int getCountStudies(int id) {
        try (Session session = sessionFactory.openSession()){
            Student student = getById(id);
            return student.getCountStudies();
        }
    }



}
