package com.example.rest_api.repository;

import ch.qos.logback.core.net.server.AbstractServerSocketAppender;
import com.example.rest_api.database.FaceDB;
import com.example.rest_api.exception.BadRequestExcepton;
import com.example.rest_api.exception.NotFoundException;
import com.example.rest_api.model.PagaUser;
import com.example.rest_api.model.User;
import com.example.rest_api.model.UserDto;
import com.example.rest_api.request.UpsertPasswordRequest;
import com.example.rest_api.request.UpsertUserRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class UserRepository {
    public List<User> findALl(){

        return FaceDB.users;
    }
    public List<UserDto> getUserByName(String name) {
        List<UserDto> result = new ArrayList<>();
        for(User user : FaceDB.users){
            if(findName(user.getName()).equals(name)){
                UserDto userDto = new UserDto(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPhone(),
                        user.getAddress(),
                        user.getAvatar()
                );
                result.add(userDto);
            }
        }
        return result;
    }
    private String findName(String name){
        String[] strings = name.split(" ");
        return strings[strings.length -1].trim().toLowerCase();
    }

    public Optional<User> findUserById(int id) {
        return FaceDB.users
                .stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public User createUser(UpsertUserRequest request) {
        Random rd = new Random();
        int id;
        do {
            id = rd.nextInt(200);
        }while (getAllID().contains(id));
        User user = new User(
                id,
                request.getName(),
                request.getEmail(),
                request.getPhone(),
                request.getAddress(),
                request.getAvatar(),
                request.getPassword()
        );
        FaceDB.users.add(user);
        return user;
    }
    private List<Integer> getAllID(){
        List<Integer> list = new ArrayList<>();
        for(User user : FaceDB.users){
            list.add(user.getId());
        }
        return list;
    }

    public void updateUser(UpsertUserRequest request, int id) {
        User user = findUserById(id).orElseThrow(()->{
            throw new NotFoundException("Not found exception with " + id);
        });
        user.setName(request.getName());
        user.setAddress(request.getAddress());
        user.setPhone(request.getPhone());
    }

    public void deleteUser(int id) {
        FaceDB.users.removeIf(user -> user.getId() == id);
    }

    public void updateAvatar(UpsertUserRequest request, int id) {
        if(findUserById(id).isPresent()){
            for(User user1 : FaceDB.users){
                if(user1.getId()==id){
                    user1.setAvatar(request.getAvatar());
                }
            }
        }
        else throw new NotFoundException("Not found exception with " + id);

    }

    public void updatePassword(UpsertPasswordRequest request, int id) {
        User user = findUserById(id).orElseThrow(()->{
            throw new NotFoundException("Not found exception with " + id);
        });
        if(!request.getOldPassword().equals(user.getPassword()))
            throw new NotFoundException("Mật khẩu cũ không chính xác");
        if (request.getOldPassword().equals(request.getNewPassword()))
            throw new BadRequestExcepton("Mật khẩu mới giống mật khẩu cũ ");
        for(User user1 : FaceDB.users){
            if(user1.getId()==id){
                user.setPassword(request.getNewPassword());
            }
        }
    }

    public String fotgotPassword(int id) {
        User user = findUserById(id).orElseThrow(()->{
            throw new NotFoundException("Not found exception with " + id);
        });
        user.setPassword(user.getPassword()+'1');
        return user.getPassword();
    }

    public PagaUser getPageUser(int page, int limit) {
        int totalPage = (FaceDB.users.size()/limit) + 1;
        int size = limit;
        int currentPage = page;
        int n = (page-1)*limit;
        List<User> list = new ArrayList<>();
        while (n < Math.min(FaceDB.users.size()-(page-1)*limit,limit)){
            list.add(FaceDB.users.get(n));
            n++;
        }
        return new PagaUser(list,currentPage,size,totalPage);
    }


}
