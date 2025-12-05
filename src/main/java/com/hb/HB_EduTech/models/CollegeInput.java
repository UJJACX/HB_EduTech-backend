package com.hb.HB_EduTech.models;

import lombok.Data;
import java.util.List;


public class CollegeInput {
    private String college_name;
    private String college_code;
    private String branch_name;
    private String branch_code;
    private String status;
    private String home_university;
    private List<LevelInput> levels;

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getCollege_code() {
        return college_code;
    }

    public void setCollege_code(String college_code) {
        this.college_code = college_code;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHome_university() {
        return home_university;
    }

    public void setHome_university(String home_university) {
        this.home_university = home_university;
    }

    public List<LevelInput> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelInput> levels) {
        this.levels = levels;
    }
}