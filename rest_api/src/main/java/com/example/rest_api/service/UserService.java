package com.example.rest_api.service;

import com.example.rest_api.database.FaceDB;
import com.example.rest_api.exception.NotFoundException;
import com.example.rest_api.model.PagaUser;
import com.example.rest_api.model.User;
import com.example.rest_api.model.UserDto;
import com.example.rest_api.repository.UserRepository;
import com.example.rest_api.request.UpsertPasswordRequest;
import com.example.rest_api.request.UpsertUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<UserDto> getUserByName(String name) {
        return userRepository.getUserByName(name);
    }
   public UserDto createUser(UpsertUserRequest request) {
               UserDto userDto = new UserDto(
                       userRepository.createUser(request).getId(),
                       userRepository.createUser(request).getName(),
                       userRepository.createUser(request).getEmail(),
                       userRepository.createUser(request).getPhone(),
                       userRepository.createUser(request).getAddress(),
                       userRepository.createUser(request).getAvatar()
        );
        return userDto;
    }

    public UserDto updateUser(UpsertUserRequest request, int id) {
        userRepository.updateUser(request,id);
        return  findUserById(id);

    }
    public void deleteUser(int id) {
    userRepository.deleteUser(id);

    }
    public UserDto findUserById(int id) {
        if(userRepository.findUserById(id).isPresent()){
            UserDto userDto = new UserDto(
                    userRepository.findUserById(id).get().getId(),
                    userRepository.findUserById(id).get().getName(),
                    userRepository.findUserById(id).get().getEmail(),
                    userRepository.findUserById(id).get().getPhone(),
                    userRepository.findUserById(id).get().getAddress(),
                    userRepository.findUserById(id).get().getAvatar()
            );

            return userDto;
        }
        else throw new NotFoundException("Not found exception with " + id);
    }
    public List<User> findAll() {
        return userRepository.findALl();
    }

    public void updateAvatar(UpsertUserRequest request, int id) {
        userRepository.updateAvatar(request,id);
    }

    public void updatePassword(UpsertPasswordRequest request, int id) {
        userRepository.updatePassword(request,id);
    }

    public String fotgotPassword(int id) {
        return userRepository.fotgotPassword(id);
    }

    public PagaUser getPageUser (int page, int limit) {
        return userRepository.getPageUser(page,limit);
    }
}


