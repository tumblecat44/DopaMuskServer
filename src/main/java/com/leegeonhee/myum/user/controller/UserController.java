package com.leegeonhee.myum.user.controller;


import com.leegeonhee.myum.user.entity.User;
import com.leegeonhee.myum.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("")
    public User insertUser(@RequestBody User userItem) {
        return userService.insertUser(userItem);
    }

    @GetMapping("")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{userId}")
    public Optional<User> getUserByUserId(@PathVariable String userId) {
        return userService.getUserByUserId(userId);
    }

    @PostMapping("/userName")
    public ResponseEntity<Map<String,String>> getUserNameByUserId(@RequestBody User user) {

        String userName = userService.getUserNameByUserId(user);
        Map<String, String> response = new HashMap<>();
        response.put("success", userName);
        if(userName != null){
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @PutMapping("/{userId}")
//    public void updateUserPw(@PathVariable String userId, @RequestBody UserDTO user) {
//        userService.updateUserPw(userId, user);
//    }
//
//    @DeleteMapping("/{userId}")
//    public void deleteUser(@PathVariable String userId) {
//        userService.deleteUser(userId);
//    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Boolean>> loginUser(@RequestBody User user) {
        boolean isLoginSuccessful = userService.loginUser(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("success", isLoginSuccessful);
        return new ResponseEntity<>(response, (isLoginSuccessful)? HttpStatus.OK:HttpStatus.UNAUTHORIZED);
    }

}
