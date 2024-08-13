package com.leegeonhee.myum.user.service;

import com.leegeonhee.myum.user.entity.User;
import com.leegeonhee.myum.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User insertUser(User userItem){
        return userRepository.save(userItem);
    }
    public List<User> getAllUser()
    {
        return userRepository.findAll();
    }

    public Optional<User> getUserByUserId(String user){
        return userRepository.findByUserId(user);
    }

    public String getUserNameByUserId(User user){
        Optional<User> foundUser = userRepository.findByUserId(user.getUserId());
        return foundUser.map(User::getUserName).orElse(null);
    }

    public boolean loginUser(User user) {
        Optional<User> foundUser = userRepository.findByUserId(user.getUserId());
        if(foundUser.isPresent()){
            User userItem = foundUser.get();
            boolean he = userItem.getUserPw().equals(user.getUserPw());
            System.out.println("adjadjkkdaj");
            return he;
        }else{
            return false;
        }

    }
}
