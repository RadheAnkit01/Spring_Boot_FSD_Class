package org.example.dao;

import org.example.model.Student;
import org.example.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDao {
    public List<Student> findAll(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Student order by id", Student.class).list();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    public Student findById(long id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(Student.class,id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(Student student){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try {
                if(student == null) return;
                session.persist(student);
                transaction.commit();
            } catch (RuntimeException e) {
                transaction.rollback();
                throw new RuntimeException(e);
            }
        }catch (RuntimeException e){
            throw e;
        }
    }

    public void delete(long id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            try{
                Student student = session.find(Student.class,id);
                if(student == null) return;
                session.remove(student);
                tx.commit();
            } catch (RuntimeException e) {
                tx.commit();
                throw new RuntimeException(e);
            }
        }
    }

    public void update(Student student){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            try{
                if (student == null) return;
                session.merge(student);
                tx.commit();
            } catch(Exception e){
                tx.rollback();
                throw e;
            }
        } catch(RuntimeException e){
            throw e;
        }
    }

    public Student findByEmail(String email) {
        try (var session = HibernateUtil.getSessionFactory()
                .openSession()) {

            return session.createQuery(
                            "FROM Student s WHERE s.email = :email",
                            Student.class
                    )
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }
}
