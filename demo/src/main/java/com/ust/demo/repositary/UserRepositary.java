package com.ust.demo.repositary;

import com.ust.demo.model.User;
import com.ust.demo.model.UserPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositary extends JpaRepository<User, UserPK> {



}
