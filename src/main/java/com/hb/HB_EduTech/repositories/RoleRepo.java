package com.hb.HB_EduTech.repositories;

import com.hb.HB_EduTech.entities.Roles;
import com.hb.HB_EduTech.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Roles, Integer> {

}
