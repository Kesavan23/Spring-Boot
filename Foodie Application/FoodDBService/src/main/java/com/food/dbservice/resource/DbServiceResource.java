package com.food.dbservice.resource;


import com.food.dbservice.model.User;
import com.food.dbservice.repository.UserRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

    private UserRepository userRepository;

    public DbServiceResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{username}")
    public List<String> getUser(@PathVariable("username") final String username) {

        return getUserByUserName(username);
    }

    @PostMapping("/add")
    public List<String> add(@RequestBody final User user) {

    	userRepository.save(user);
        return getUserByUserName(user.getUserName());
    }


    @PostMapping("/delete/{username}")
    public List<String> delete(@PathVariable("username") final String username) {

        List<User> user = userRepository.findByUserName(username);
        userRepository.delete(user);

        return getUserByUserName(username);
    }





}
