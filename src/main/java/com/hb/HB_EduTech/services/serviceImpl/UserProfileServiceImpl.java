package com.hb.HB_EduTech.services.serviceImpl;

import com.hb.HB_EduTech.entities.User;
import com.hb.HB_EduTech.entities.UserProfile;
import com.hb.HB_EduTech.models.UserProfileDto;
import com.hb.HB_EduTech.repositories.UserProfileRepo;
import com.hb.HB_EduTech.repositories.UserRepo;
import com.hb.HB_EduTech.services.service.UserProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {


    @Autowired
    UserProfileRepo userProfileRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String createProfile(UserProfileDto userProfileDto) {
        ModelMapper mapper = new ModelMapper();
        UserProfile userProfile = mapper.map(userProfileDto, UserProfile.class);

        if (userProfileDto.getUserId() != 0) {
            User user = userRepo.findById(userProfileDto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            userProfile.setUser(user);
        } else {
            throw new RuntimeException("User ID is required");
        }

        userProfileRepo.save(userProfile);
        return "Profile created successfully";
    }


    @Override
    public Optional<UserProfile> getUserProfile(int user_id) {
        ModelMapper mapper = new ModelMapper();
        UserProfile userProfile = mapper.map(user_id, UserProfile.class);
        return Optional.of(userProfileRepo.getReferenceById(user_id));
    }


    @Override
    public String updateProfile(UserProfileDto userProfileDto) {
        Optional<UserProfile> userProfile = userProfileRepo.findByUser_UserId(userProfileDto.getUserId());

        if (userProfile.isPresent()) {
            UserProfile existingProfile = userProfile.get();
            modelMapper.map(userProfileDto, existingProfile);
            userProfileRepo.save(existingProfile);
            return "Profile updated successfully";
        } else {
            return "Profile not found!";
        }
    }


}
