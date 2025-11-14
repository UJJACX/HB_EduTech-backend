package com.hb.HB_EduTech.models;

import com.hb.HB_EduTech.entities.UserProfile;
import lombok.*;

import java.util.Optional;

public class ResponseDto {

    public int status;
    public Object data;
    public String message;

    public ResponseDto(int status, String message){
        this.status = status;
        this.message = message;
    }

    public ResponseDto(int status, String message, Object data) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public ResponseDto(int status, Optional<UserProfile> userProfile) {
    }
}
