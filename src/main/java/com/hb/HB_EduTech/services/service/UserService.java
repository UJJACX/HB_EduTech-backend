package com.hb.HB_EduTech.services.service;


import com.hb.HB_EduTech.entities.User;
import com.hb.HB_EduTech.models.AuthResponse;
import com.hb.HB_EduTech.models.UserDto;
import com.hb.HB_EduTech.repositories.UserRepo;
import com.hb.HB_EduTech.security.JWTHelper;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
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

    @Autowired
    ModelMapper modelMapper;

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

    public void logout(UserDto userData) {
        Optional<User> user = repository.findByUsername(userData.getUsername());
        user.get().setToken(null);
        repository.save(user.get());
    }

    public String deleteStudent(UserDto userData) {
        User user = repository.findByUsername(userData.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found: "));

        repository.deleteById(user.getUserId());
        return "Student Deleted Successfully";
    }

    public String updateStudent(UserDto userDto) {
        Optional<User> user = repository.findByUsername(userDto.getUsername());

        if(user.isPresent()){
            User existingUser = user.get();
            modelMapper.map(userDto,existingUser);
            repository.save(existingUser);
        }
        return "Student Data Updated";
    }
}
