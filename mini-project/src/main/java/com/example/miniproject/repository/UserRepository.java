package com.example.miniproject.repository;

import com.example.miniproject.database.UserFakeDB;
import com.example.miniproject.model.User;
import com.example.miniproject.request.UserRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class UserRepository {  public Optional<User> findByRequest(UserRequest userRequest){
    return UserFakeDB.users.stream()
            .filter(user -> (user.getUsername().equals(userRequest.getUsername())
                    && user.getPassword().equals(userRequest.getPassword())))
            .findFirst();
}
}
