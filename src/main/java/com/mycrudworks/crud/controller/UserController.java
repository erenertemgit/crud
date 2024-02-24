package com.mycrudworks.crud.controller;

import com.mycrudworks.crud.model.User;
import com.mycrudworks.crud.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")

@NoArgsConstructor
public class UserController {
    @Autowired
    private UserRepository userRepository;

//    private UserController(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/{userId}")
    public Optional<User> getOneUser(@PathVariable Long userId){
        return userRepository.findById(userId);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser){
        Optional<User> user = userRepository.findById(userId);
        User foundUser = user.get();
        foundUser.setName(newUser.getName());
        foundUser.setSurname(newUser.getSurname());
        userRepository.save(foundUser);
        User foundUser1 = foundUser;
        return foundUser1;

        }
        @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId){
        userRepository.deleteById(userId);
        }


}
