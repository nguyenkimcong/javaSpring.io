package com.example.rest_api.controller;

import com.example.rest_api.model.PagaUser;
import com.example.rest_api.model.User;
import com.example.rest_api.model.UserDto;
import com.example.rest_api.request.UpsertPasswordRequest;
import com.example.rest_api.request.UpsertUserRequest;
import com.example.rest_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService ;

    // Get all
    @GetMapping("usersall")
    public List<User> getAll(){
        return userService.findAll();
    }

    // GET : api/v1/users : lấy danh sách user
    @GetMapping("users")
   public PagaUser getPageUser (@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit){
        return userService.getPageUser(page,limit);
    }

    // GET : api/v1/users : Tìm kiếm user theo name
 @GetMapping ("user/{name}")

    public  List<UserDto> getUserByName (@RequestParam String name){
        return userService.getUserByName(name);

 }

   // GET : api/v1/users :tìm kiếm user theo id
 @GetMapping ( "user/{id}")
    public UserDto findUserById (@PathVariable int id){
        return userService.findUserById(id);
 }

    //  POST : api/v1/users : tạo mới user
    @PostMapping ("user")
    public  UserDto createUser (@RequestBody UpsertUserRequest request){
        return  userService.createUser(request);
    }

    //PUT : api/v1/users : cập nhat thông tin
    @PutMapping ("user/{id}")
    public UserDto UpdateUser ( @RequestBody UpsertUserRequest request, @PathVariable int id) {
        return  userService.updateUser( request, id);
    }

    // DELETE : api/v1/users/{id} xóa user theo id
    @DeleteMapping ("user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
}

// PUT api/v1/users/{id}/update-avatar : thay đổi avatar
    @PutMapping("users/{id}/update-avatar")
    public void updateAvatar(@RequestBody UpsertUserRequest request,@PathVariable int id){
        userService.updateAvatar(request,id);
    }

    // PUT api/v1/users/{id}/update-password : thay đổi mat khẩu
    @PutMapping("users/{id}/update-password")
    public void updatePassword(@RequestBody UpsertPasswordRequest request, @PathVariable int id){
        userService.updatePassword(request,id);
    }

    //POST api/v1/users/{id}/fotgot-password : Quên mật khẩu
    @PostMapping("users/{id}/fotgot-password")
    public String fotgotPassword(@PathVariable int id){
        return userService.fotgotPassword(id);
    }




}
