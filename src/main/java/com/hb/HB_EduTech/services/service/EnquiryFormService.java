package com.hb.HB_EduTech.services.service;

import com.hb.HB_EduTech.models.EnquiryFormDto;
import org.springframework.stereotype.Service;

@Service
public interface EnquiryFormService {

    String studentEnquiry(EnquiryFormDto enquiryFormDto);

}
