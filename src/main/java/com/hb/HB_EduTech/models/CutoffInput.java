package com.hb.HB_EduTech.models;
import lombok.Data;


public class CutoffInput {
    private Integer rank;
    private String percentile;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getPercentile() {
        return percentile;
    }

    public void setPercentile(String percentile) {
        this.percentile = percentile;
    }
}