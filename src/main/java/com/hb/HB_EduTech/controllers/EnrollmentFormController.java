package com.hb.HB_EduTech.controllers;

import com.hb.HB_EduTech.models.EnrollmentFormDto;
import com.hb.HB_EduTech.models.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollmentFormController {

    @PostMapping(value = "enrollStudent")
    public ResponseEntity<ResponseDto> enrollStudent(EnrollmentFormDto enrollmentFormDto){
        return ResponseEntity.ok().body(new ResponseDto(200,"Student enrolled successfully"));
    }

}
