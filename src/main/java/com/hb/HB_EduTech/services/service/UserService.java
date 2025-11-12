package com.hb.HB_EduTech.services.service;


import com.hb.HB_EduTech.entities.User;
import com.hb.HB_EduTech.models.AuthResponse;
import com.hb.HB_EduTech.repositories.UserRepo;
import com.hb.HB_EduTech.security.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo repository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JWTHelper jwtHelper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userDetail = repository.findByUsername(username);

        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    };

    public String saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        return "User Added Successfully";
    }

    public AuthResponse generateToken (String username){
        String token = jwtHelper.generateToken(username);
        Optional<User> user = repository.findByUsername(username);
        user.get().setToken(token);
        repository.save(user.get());

        return new AuthResponse(token, username, user.get().getRole().getRoleName());
    }


    public void logout(String username) {
        Optional<User> user = repository.findByUsername(username);
        user.get().setToken(null);
        repository.save(user.get());
    }
}
