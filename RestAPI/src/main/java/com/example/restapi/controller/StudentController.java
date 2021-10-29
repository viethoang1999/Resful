package com.example.restapi.controller;

import com.example.restapi.dto.StudentDTO;
import com.example.restapi.entity.Student;
import com.example.restapi.service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Path("/student")
public class StudentController {
    StudentService studentService = new StudentService();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudent() {
        return studentService.getListStudent();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@PathParam("id") int id) {
        return studentService.finID(id);
    }

    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addNewStudent(StudentDTO studentDTO) {
        return studentService.insert(studentDTO) ? "Them moi thanh cong" : "Cap nhat that bai";
    }

    @PUT
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateStudent(Student student) {
        return studentService.update(student) ? "Sua thanh cong" : "Sua That bai";
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteStudent(@PathParam("id") int id) {
        return studentService.removeStudent(id) ? "Xoa thanh cong" : "Xoa that bai";

    }
}
