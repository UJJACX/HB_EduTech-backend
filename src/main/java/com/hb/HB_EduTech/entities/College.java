package com.hb.HB_EduTech.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "college_master")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "college_code")
    private String collegeCode;

    @Column(name = "college_name")
    private String collegeName;

    private String status;

    @Column(name = "home_university")
    private String homeUniversity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollegeCode() {
        return collegeCode;
    }

    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHomeUniversity() {
        return homeUniversity;
    }

    public void setHomeUniversity(String homeUniversity) {
        this.homeUniversity = homeUniversity;
    }

}
