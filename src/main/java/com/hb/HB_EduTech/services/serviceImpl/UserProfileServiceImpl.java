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

    @Override
    public String createProfile(UserProfileDto userProfileDto) {
        ModelMapper mapper = new ModelMapper();
        UserProfile userProfile = mapper.map(userProfileDto, UserProfile.class);

        // ✅ Fetch the existing user from DB
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
    public String updateProfile(UserProfileDto userProfileDto, int profile_id) {
        Optional<UserProfile> userProfile = userProfileRepo.findById(profile_id);
        if (userProfile.isPresent()) {

            UserProfile existingProfile = userProfile.get();

            if (userProfileDto.getFirstName() != null) existingProfile.setFirstName(userProfileDto.getFirstName());
            if (userProfileDto.getMiddleName() != null) existingProfile.setMiddleName(userProfileDto.getMiddleName());
            if (userProfileDto.getLastName() != null) existingProfile.setLastName(userProfileDto.getLastName());
            if (userProfileDto.getContactNumber() != null) existingProfile.setContactNumber(userProfileDto.getContactNumber());
            if (userProfileDto.getDob() != null) existingProfile.setDob(userProfileDto.getDob());
            if (userProfileDto.getGender() != null) existingProfile.setGender(userProfileDto.getGender());
            if (userProfileDto.getMothersName() != null) existingProfile.setMothersName(userProfileDto.getMothersName());
            if (userProfileDto.getFathersName() != null) existingProfile.setFathersName(userProfileDto.getFathersName());
            if (userProfileDto.getInterestedIn() != null) existingProfile.setInterestedIn(userProfileDto.getInterestedIn());
            if (userProfileDto.getLocation() != null) existingProfile.setLocation(userProfileDto.getLocation());
            if (userProfileDto.getCity() != null) existingProfile.setCity(userProfileDto.getCity());
            if (userProfileDto.getSchoolName() != null) existingProfile.setSchoolName(userProfileDto.getSchoolName());
            if (userProfileDto.getBoardName() != null) existingProfile.setBoardName(userProfileDto.getBoardName());
            if (userProfileDto.getState() != null) existingProfile.setState(userProfileDto.getState());

            // ✅ Use wrapper Double instead of primitive double to allow null checks
            if (userProfileDto.getPercentage() != 0.0) existingProfile.setPercentage(userProfileDto.getPercentage());
            if (userProfileDto.getYear() != null ) existingProfile.setYear(userProfileDto.getYear());

            userProfileRepo.save(existingProfile);
            return "Profile updated successfully";
        } else {
            return "Profile not found!";

        }

    }


}
