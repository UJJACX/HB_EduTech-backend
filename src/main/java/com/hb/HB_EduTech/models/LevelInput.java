package com.hb.HB_EduTech.models;

import lombok.Data;
import java.util.Map;


public class LevelInput {
    private String level;
    private Map<String, CutoffInput> cutoffs;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Map<String, CutoffInput> getCutoffs() {
        return cutoffs;
    }

    public void setCutoffs(Map<String, CutoffInput> cutoffs) {
        this.cutoffs = cutoffs;
    }
}