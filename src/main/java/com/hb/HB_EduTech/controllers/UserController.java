package com.hb.HB_EduTech.controllers;

import com.hb.HB_EduTech.entities.User;
import com.hb.HB_EduTech.models.JwtRequest;
import com.hb.HB_EduTech.models.ResponseDto;
import com.hb.HB_EduTech.repositories.UserInfoRepository;
import com.hb.HB_EduTech.security.JWTHelper;
import com.hb.HB_EduTech.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private JWTHelper jwtHelper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    UserService userService;

    @PostMapping(value = "/saveUser")
    public ResponseEntity<ResponseDto> saveUser(@RequestBody User user) {
        return ResponseEntity.ok().body(new ResponseDto(200, "Login Successfull", userService.addUser(user)));
    }

    @PostMapping("/generateToken")
    public ResponseEntity<ResponseDto> authenticateAndGetToken(@RequestBody JwtRequest jwtRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok().body(new ResponseDto(200, "Login Successfull", jwtHelper.generateToken(jwtRequest.getUsername())));
        } else {
            return ResponseEntity.ok().body(new ResponseDto(200, "Invalid Credentials"));
        }
    }

}
