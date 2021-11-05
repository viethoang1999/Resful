package com.example.restapi.reponsitory;

import com.example.restapi.entity.Student;
import com.example.restapi.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

public class StudentDao {
    Logger logger = Logger.getLogger(String.valueOf(StudentDao.class));

    public List<Student> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("from Student ").list();

        } catch (HibernateException e) {
            System.out.println(e);
            session.getTransaction().rollback();
//            logger.err(e);
        }
        return null;
    }

    public Student findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Student> query = session.createQuery("select  s from Student s where  s.id= :p_student_id");
            query.setParameter("p_student_id", id);
            return query.getSingleResult();
        } catch (HibernateException e) {
            System.out.println(e);
            session.getTransaction().rollback();
        }
        return null;
    }

    public boolean insert(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            System.out.println(e);
            session.getTransaction().rollback();
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
            System.out.println(e);
            session.getTransaction().rollback();
        }
        return false;
    }

    public List<Student> happyBirthDay() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            LocalDate day = LocalDate.now();
            int month = day.getMonthValue();
            int day1 = day.getDayOfMonth();
            Query<Student> query = session.createQuery("from  Student where  to_number(to_char(birthday,'MM'))=:p_month and to_number(to_char(birthday,'dd'))=:p_day");
            query.setParameter("p_month", month);
            query.setParameter("p_day", day1);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
        }
        return null;
    }

    public List<Student> searchName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query<Student> query = session.createQuery(" from Student where lower(fullname)like lower(to_char(concat(concat('%',:p_student_name),'%' ))) ");
            query.setParameter("p_student_name", name);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }

    public List<Student> searchMajor(String major) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query<Student> query = session.createQuery(" from Student where lower(major)like lower(to_char(concat(concat('%',:p_student_major),'%' ))) ");
            query.setParameter("p_student_major", major);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }

    public List<Student> searchGender(String gender) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query<Student> query = session.createQuery(" from Student where lower(gender)like lower(to_char(concat(concat('%',:p_student_gender),'%' ))) ");
            query.setParameter("p_student_gender", gender);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }

    public List<Student> searchHometown(String hometown) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query<Student> query = session.createQuery(" from Student where lower(hometown)like lower(to_char(concat(concat('%',:p_student_hometown),'%' ))) ");
            query.setParameter("p_student_hometown", hometown);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }

    public List<Student> searchClassName(String className) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query<Student> query = session.createQuery(" from Student where lower(classname)like lower(to_char(concat(concat('%',:p_student_className),'%' ))) ");
            query.setParameter("p_student_className", className);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }

}
