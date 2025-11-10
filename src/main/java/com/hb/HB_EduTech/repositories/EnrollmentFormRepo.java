package com.hb.HB_EduTech.repositories;

import com.hb.HB_EduTech.entities.EnrollmentForm;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentFormRepo extends JpaRepository<EnrollmentForm, Long> {
}
