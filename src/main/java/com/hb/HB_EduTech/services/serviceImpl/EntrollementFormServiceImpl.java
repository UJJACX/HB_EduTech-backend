package com.hb.HB_EduTech.services.serviceImpl;

import com.hb.HB_EduTech.entities.EnrollmentForm;
import com.hb.HB_EduTech.models.EnrollmentFormDto;
import com.hb.HB_EduTech.repositories.EnrollmentFormRepo;
import com.hb.HB_EduTech.services.service.EnrollmentFormService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrollementFormServiceImpl implements EnrollmentFormService {

    @Autowired
    EnrollmentFormRepo enrollmentFormRepo;

    @Override
    public String enrollStudent(EnrollmentFormDto enrollmentFormDto) {
        ModelMapper modelMapper = new ModelMapper();
        EnrollmentForm enrollmentForm = modelMapper.map(enrollmentFormDto, EnrollmentForm.class);
        enrollmentFormRepo.save(enrollmentForm);
        return "Student Enrolled Successfully";
    }

}
