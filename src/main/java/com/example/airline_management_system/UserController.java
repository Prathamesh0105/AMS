package com.example.airline_management_system;

import com.example.airline_management_system.data.UserInfo;
import com.example.airline_management_system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping()
    List<UserInfo> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping()
    UserInfo createUser(@RequestBody UserInfo userInfo){
        return userService.createUser(userInfo);
    }
}
