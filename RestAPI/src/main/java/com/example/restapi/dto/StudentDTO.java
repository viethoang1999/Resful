package com.example.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.*;

import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDTO {

    private Integer id;
    private String fullname;
    private String birthday;
    private String classname;
    private String major;
    private String hometown;
    private String gender;
    private Double avergemark;
}
