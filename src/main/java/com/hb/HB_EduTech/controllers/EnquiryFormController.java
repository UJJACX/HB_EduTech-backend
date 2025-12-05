//package com.hb.HB_EduTech.controllers;
//
//import com.hb.HB_EduTech.entities.User;
//import com.hb.HB_EduTech.models.EnquiryFormDto;
//import com.hb.HB_EduTech.models.ResponseDto;
//import com.hb.HB_EduTech.services.service.EnquiryFormService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(value = "/enquiry")
//public class EnquiryFormController {
//
//    @Autowired
//    EnquiryFormService enquiryFormService;
//
//    @PostMapping(value = "/registerEnquiry")
//    public ResponseEntity<ResponseDto> registerEnquiry(@RequestBody EnquiryFormDto enquiryFormDto) {
//        try {
//            System.out.println("*****************************");
//            return ResponseEntity.ok().body(new ResponseDto(200, enquiryFormService.studentEnquiry(enquiryFormDto)));
//        } catch (Exception e){
//            return ResponseEntity.internalServerError().body(new ResponseDto(500, e.getMessage()));
//        }
//    }
//
//}
