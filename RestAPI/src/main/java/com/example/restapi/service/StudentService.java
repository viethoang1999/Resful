package com.example.restapi.service;

import com.example.restapi.dto.StudentDTO;
import com.example.restapi.entity.Student;
import com.example.restapi.reponsitory.StudentDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class StudentService {
    StudentDao studentDao = new StudentDao();

    public List<Student> getListStudent() {
        return studentDao.getAll();
    }

    public Student finID(int id) {
        return studentDao.findById(id);
    }

    public boolean insert(StudentDTO studentDTO) {
        Student student = new Student();
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        student.setAverage_mark(studentDTO.getAvergemark());
        try {
            student.setBirthday(date.parse(studentDTO.getBirthday()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setGender(studentDTO.getGender());
        student.setClassname(studentDTO.getClassname());
        student.setHometown(studentDTO.getHometown());
        student.setMajor(studentDTO.getMajor());
        student.setFullname(studentDTO.getFullname());
//        List<Student> students = studentDao.getAll();
//        students.sort((o1, o2) -> o1.getId() < o2.getId() ? 1 : -1);
//        int id = students.get(0).getId() + 1;
//        student.setId(id);
//        if (student.getFullname() == null) {
//            return false;
//        }
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

    //private StringBuilder mess;

//    public boolean checkInput(Student student) {
//        mess = new StringBuilder("Khong the tao sv");
//        boolean agreed = true;
//        if (student.getFullname() == null || student.getFullname().isEmpty() || student.getFullname().length() < 1 || student.getFullname().length() > 50) {
//            mess.append("Ten : Khong duoc qua 1-50");
//            agreed = false;
//        }
//        if (student.getBirthday() == null) {
//            mess.append("Ngay sinh: khong hop le");
//            agreed = false;
//        }
////        else {
////            Period period = Period.between(student.getBirthday().toLocalDate(), LocalDate.now());
////            if (period.getYears() > 150 || period.getYears() < 1) {
////                mess.append("Tuoi : khong nho hon 1 vaf qua 150");
////                agreed = false;
//
//    //}
//}
//        }
//        if (student.getClassname() == null || student.getClassname().isEmpty()) {
//            mess.append("Ten lop : Khong hop le");
//            agreed = false;
//        }
//        if (student.getGender() == null || student.getGender().isEmpty()) {
//            !(student.getGender().equalsIgnoreCase("Nam") || student.getGender().equalsIgnoreCase("Nu") || student.getGender().equalsIgnoreCase("Khac"))
//            {
//                mess.append("Gioi tinh: Khong hop le");
//                agreed = false;
//            }
//        }
//        if (student.getHometown() == null || student.getHometown().isEmpty()) {
//            mess.append("Que: Khong hop le");
//            agreed = false;
//        }
//        if (student.getMajor() == null || student.getMajor().isEmpty()) {
//            mess.append("Khoa: Khong hop le");
//
//        }
//        if (student.getAverage_mark() < 0 || student.getAverage_mark() > 10) {
//            mess.append("Diem : khong hop le");
//            agreed = false;
//        }
//        return agreed;
//    }
//
//    public String getMess() {
//        return mess.toString();
//    }
}
