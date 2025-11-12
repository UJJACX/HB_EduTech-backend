package com.hb.HB_EduTech.services.serviceImpl;

import com.hb.HB_EduTech.entities.EnquiryForm;
import com.hb.HB_EduTech.models.EnquiryFormDto;
import com.hb.HB_EduTech.repositories.EnquiryFormRepo;
import com.hb.HB_EduTech.services.service.EnquiryFormService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnquiryFromServiceImpl implements EnquiryFormService {

    @Autowired
    EnquiryFormRepo enquiryFormRepo;

    @Override
    public String studentEnquiry(EnquiryFormDto enquiryFormDto) {
        ModelMapper mapper = new ModelMapper();
        EnquiryForm enquiryForm = mapper.map(enquiryFormDto, EnquiryForm.class);
        enquiryFormRepo.save(enquiryForm);
        return "Enquiry Registered";
    }
}
