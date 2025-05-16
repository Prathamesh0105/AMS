package com.example.airline_management_system.services;

import com.example.airline_management_system.data.UserInfo;
import com.example.airline_management_system.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    UserInfoRepository userInfoRepository;
    public List<UserInfo> getAllUsers(){
        return userInfoRepository.getAllUsers();
    }
    public UserInfo createUser(UserInfo userInfo){
        return userInfoRepository.createUser(userInfo);
    }

}
