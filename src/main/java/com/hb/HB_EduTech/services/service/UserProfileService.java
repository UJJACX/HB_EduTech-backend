package com.hb.HB_EduTech.services.service;

import com.hb.HB_EduTech.entities.UserProfile;
import com.hb.HB_EduTech.models.UserProfileDto;
import com.hb.HB_EduTech.services.serviceImpl.UserProfileServiceImpl;

import java.util.Optional;

public interface UserProfileService  {

    public String createProfile(UserProfileDto userProfileDto);

    public Optional<UserProfile> getUserProfile(int user_id);

    public String updateProfile(UserProfileDto userProfileDto);
}
