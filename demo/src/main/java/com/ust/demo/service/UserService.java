package com.ust.demo.service;

import com.ust.demo.model.User;
import com.ust.demo.model.UserPK;
import com.ust.demo.repositary.UserRepositary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepositary userRepositary;

    public User SaveUser(User user){
        return userRepositary.save(user);

    }
    public Optional<User> findUser(int userId, String userType) {
        UserPK u = new UserPK(userId,userType);
        try{
            return userRepositary.findById(u);
        }catch (Exception e){
            log.error("Error while finding user with userId: {} and userType: {}. Error message: {}", userId, userType, e.getMessage());
        }
        return Optional.empty();
    }


}
