package com.hb.HB_EduTech.controllers;

import com.hb.HB_EduTech.entities.UserProfile;
import com.hb.HB_EduTech.models.ResponseDto;
import com.hb.HB_EduTech.models.UserProfileDto;
import com.hb.HB_EduTech.repositories.UserProfileRepo;
import com.hb.HB_EduTech.services.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profile")
public class UserProfileController {
    @Autowired
    UserProfileService userProfileService;

    @Autowired
    UserProfileRepo userProfileRepo;
    @PostMapping("/create-profile")
    public ResponseEntity<ResponseDto> createProfile(@RequestBody UserProfileDto userProfileDto){
        try{
            return ResponseEntity.ok().body(new ResponseDto(200, userProfileService.createProfile(userProfileDto)));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseDto(500, e.getMessage()));
        }

    }


//    @GetMapping("/get-user-profile")
//    public ResponseEntity<ResponseDto> getUserProfile(@RequestParam int user_id){
//        try{
//            return ResponseEntity.ok().body(new ResponseDto(200,"Profile Data", userProfileRepo.findById(user_id)));
//        }catch (Exception e){
//            return ResponseEntity.internalServerError().body(new ResponseDto(500, e.getMessage()));
//        }
//    }

    @GetMapping("/get-user-profile")
    public ResponseEntity<ResponseDto> getUserProfile(@RequestParam int user_id) {
        try {
            UserProfile profile = userProfileRepo.findByUser_UserId(user_id).orElse(null);
            System.out.println(userProfileRepo.findByUser_UserId(user_id));
            System.out.println(user_id);
            if (profile == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseDto(404, "Profile not found", null));
            }

            return ResponseEntity.ok(new ResponseDto(200, "Profile Data", profile));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ResponseDto(500, e.getMessage(), null));
        }
    }




    @PutMapping("/update-profile")
    public ResponseEntity<ResponseDto> updateUserProfile(@RequestBody UserProfileDto userProfileDto, @RequestParam int profile_id){
        try{
            return ResponseEntity.ok().body(new ResponseDto(200, userProfileService.updateProfile(userProfileDto, profile_id)));
        }catch (Exception e){

        }
        return null;
    }

}
