package org.example.dao;


import org.example.model.Department;
import org.example.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

import java.util.List;

public class DepartmentDao {

//    private SessionFactory sessionFactory;

//    public DepartmentDao(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    public List<Department> getAllDepartments() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Department", Department.class).list();
        }catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveDepartment(Department department) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try {
                if(department == null) return;
                session.persist(department);
                transaction.commit();
            } catch (RuntimeException e) {
                transaction.rollback();
                throw new RuntimeException(e);
            }
        }catch (RuntimeException e){
            throw e;
        }
    }

    public Department getDepartmentById(int departmentId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(Department.class,departmentId);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDepartment(Department department) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            try{
                if (department == null) return;
                session.merge(department);
                tx.commit();
            } catch(Exception e){
                tx.rollback();
                throw e;
            }
        } catch(RuntimeException e){
            throw e;
        }
    }

    public void deleteDepartment(int departmentId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            try{
                Department department = session.find(Department.class,departmentId);
                if(department == null) return;
                session.remove(department);
                tx.commit();
            } catch (RuntimeException e) {
                tx.commit();
                throw new RuntimeException(e);
            }
        }
    }
}