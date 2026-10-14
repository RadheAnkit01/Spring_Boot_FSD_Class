package org.example.dao;

import org.example.model.Employee;
import org.example.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDao {
    public List<Employee> findAll(){
        try (Session sesion = HibernateUtil.getSessionFactory().openSession()){

            return sesion.createQuery("from Employee order by id", Employee.class).list();

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    public Employee findById(long id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(Employee.class,id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(Employee employee){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try {
                if(employee == null) return;
                session.persist(employee);
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
                Employee employee = session.find(Employee.class,id);
                if(employee == null) return;
                session.remove(employee);
                tx.commit();
            } catch (RuntimeException e) {
                tx.commit();
                throw new RuntimeException(e);
            }
        }
    }

    public void update(Employee employee){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            try{
                if (employee == null) return;
                session.merge(employee);
                tx.commit();
            } catch(Exception e){
                tx.rollback();
                throw e;
            }
        } catch(RuntimeException e){
            throw e;
        }
    }
}
