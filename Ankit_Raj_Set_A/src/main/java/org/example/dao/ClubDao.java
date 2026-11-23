package org.example.dao;

import org.example.model.Club;
import org.example.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClubDao {
    public List<Club> findAll(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Club order by id", Club.class).list();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    public Club findById(long id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(Club.class,id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(Club club){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            try {
                if(club == null) return;
                session.persist(club);
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
                Club club = session.find(Club.class,id);
                if(club == null) return;
                session.remove(club);
                tx.commit();
            } catch (RuntimeException e) {
                tx.commit();
                throw new RuntimeException(e);
            }
        }
    }

    public void update(Club club){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            try{
                if (club == null) return;
                session.merge(club);
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
