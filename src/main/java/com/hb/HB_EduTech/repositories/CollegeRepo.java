package com.hb.HB_EduTech.repositories;

import com.hb.HB_EduTech.entities.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepo extends JpaRepository<College, Long> {
    College findByCollegeCode(String collegeCode);
}
