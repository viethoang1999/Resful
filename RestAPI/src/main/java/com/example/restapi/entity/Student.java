package com.example.restapi.entity;

import com.example.restapi.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_STUDENT_ID")
    @SequenceGenerator(name = "GEN_STUDENT_ID", sequenceName = "SEQ_STUDENT", allocationSize = 1)
//    @Column(nullable = false)
    private int id;
    @Column(name = "full_name", nullable = false)
    private String fullname;
    @Column(nullable = false)
    private Date birthday;
    @Column(name = "class_name", nullable = false)
    private String classname;
    @Column(name = "major", nullable = false)
    private String major;
    @Column(name = "home_town", nullable = false)
    private String hometown;
    @Column(name = "gender", nullable = false)
    private String gender;
    @Column(name = "average_mark", nullable = false)
    private double average_mark;


}
