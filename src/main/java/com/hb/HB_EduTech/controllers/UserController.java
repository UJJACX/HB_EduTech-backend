package com.hb.HB_EduTech.controllers;

import com.hb.HB_EduTech.entities.User;
import com.hb.HB_EduTech.models.AuthtRequest;
import com.hb.HB_EduTech.models.ResponseDto;
import com.hb.HB_EduTech.models.UserDto;
import com.hb.HB_EduTech.repositories.UserRepo;
import com.hb.HB_EduTech.services.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    private UserRepo userInfoRepository;

    @PostMapping(value = "/saveUser")
    public ResponseEntity<ResponseDto> saveUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok().body(new ResponseDto(200, userService.saveUser(user)));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseDto(500, e.getMessage()));
        }
    }

    @GetMapping("/getUser")
    public ResponseEntity<ResponseDto> getUser(@RequestParam String username) {
        try {
            return ResponseEntity.ok().body(new ResponseDto(200, "User Data", userInfoRepository.findByUsername(username)));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseDto(500, e.getMessage()));
        }
    }

    @PostMapping("/generateToken")
    public ResponseEntity<ResponseDto> generateToken(@RequestBody AuthtRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            if (authentication.isAuthenticated()) {
                return ResponseEntity.ok().body(new ResponseDto(200, "Login Successful", userService.generateToken(request.getUsername())));
            } else {
                return ResponseEntity.ok().body(new ResponseDto(200, "Invalid Credentials"));
            }
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseDto(500, e.getMessage()));
        }
    }

    @PostMapping("/logoutStudent")
    public ResponseEntity<ResponseDto> logout(@RequestBody UserDto userData) {
        try {
            userService.logout(userData);
            return ResponseEntity.ok().body(new ResponseDto(200, "Logout Successful"));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseDto(500, e.getMessage()));
        }
    }

    @DeleteMapping("/delete-Student")
    public ResponseEntity<ResponseDto> deleteStudent(@RequestBody UserDto userData) {
        try {
            return ResponseEntity.ok().body(new ResponseDto(200, userService.deleteStudent(userData)));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseDto(500, e.getMessage()));
        }
    }

    @PutMapping("/update-Student")
    public ResponseEntity<ResponseDto> updateStudent(@RequestBody UserDto userDto) {
        try {
            return ResponseEntity.ok().body(new ResponseDto(200, userService.updateStudent(userDto)));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(new ResponseDto(500, e.getMessage()));
        }
    }

}
