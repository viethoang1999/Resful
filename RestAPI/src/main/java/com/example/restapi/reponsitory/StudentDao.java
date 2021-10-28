package com.example.restapi.reponsitory;

import com.example.restapi.entity.Student;
import com.example.restapi.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.logging.Logger;

public class StudentDao {
    Logger logger = Logger.getLogger(String.valueOf(StudentDao.class));

    public List<Student> getAll() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("from Student ").list();

        } catch (HibernateException e) {
            e.fillInStackTrace();
//            logger.err(e);
        }
        return null;
    }

    public Student findById(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query<Student> query = session.createQuery("select  s from Student s where  s.id= :p_student_id");
            query.setParameter("p_student_id", id);
            return query.getSingleResult();
        } catch (HibernateException e) {
            e.fillInStackTrace();
        }
        return null;
    }

    public boolean insert(Student student) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.fillInStackTrace();
        }
        return false;
    }

    public boolean removeStudent(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Student student = session.load(Student.class, id);
            session.delete(student);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.fillInStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    public boolean updateStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.fillInStackTrace();
        }
        return false;
    }

}