package com.hb.HB_EduTech.repositories;

import com.hb.HB_EduTech.entities.EnquiryForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryFormRepo extends JpaRepository<EnquiryForm, Long> {
}
