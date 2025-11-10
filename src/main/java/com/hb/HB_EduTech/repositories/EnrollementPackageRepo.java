package com.hb.HB_EduTech.repositories;

import com.hb.HB_EduTech.entities.EnrollmentForm;
import com.hb.HB_EduTech.entities.EnrollmentPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollementPackageRepo  extends JpaRepository<EnrollmentPackage, Long> {
}
