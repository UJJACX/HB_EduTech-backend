package com.hb.HB_EduTech.repositories;

import com.hb.HB_EduTech.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile, Integer> {
    Optional<UserProfile> findByUser_UserId(int userId);
}
