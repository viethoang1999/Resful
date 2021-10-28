package com.example.restapi.service;

import com.example.restapi.entity.Student;
import com.example.restapi.reponsitory.StudentDao;

import java.util.List;

public class StudentService {
    StudentDao studentDao = new StudentDao();

    public List<Student> getListStudent() {
        return studentDao.getAll();
    }

    public Student finID(int id) {
        return studentDao.findById(id);
    }

    public boolean insert(Student student) {
        List<Student> students = studentDao.getAll();
        students.sort((o1, o2) -> o1.getId() < o2.getId() ? 1 : -1);
        int id = students.get(0).getId() + 1;
        student.setId(id);
        if (student.getFullname() == null) {
            return false;
        }
        return studentDao.insert(student);
    }

    public boolean removeStudent(int id) {
        return studentDao.removeStudent(id);
    }

    public boolean update(Student student) {
        if (student.getId() <= 0) {
            return false;
        }
        if (student.getFullname() == null) {
            return false;
        }
        if (student.getBirthday() == null) {
            return false;
        }
        if (student.getClassname() == null) {
            return false;
        }
        if (student.getMajor() == null) {
            return false;
        }
        if (student.getHometown() == null) {
            return false;
        }
        if (student.getGender() == null) {
            return false;
        }
        if (student.getAverage_mark() < 0) {
            return false;
        }
        return studentDao.updateStudent(student);
    }
}
