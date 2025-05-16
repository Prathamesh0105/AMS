package com.example.airline_management_system.repository;

import com.example.airline_management_system.data.UserInfo;
import com.example.airline_management_system.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class UserInfoRepository {
    Map<String, UserInfo> userInfoTable;

    @PostConstruct
    public void init() {
        userInfoTable = new HashMap<>();
    }
    public List<UserInfo> getAllUsers(){
      return userInfoTable.values()
              .stream().collect(Collectors.toList());
    }
    public UserInfo createUser(UserInfo userInfo){
        String userId=UUID.randomUUID().toString();
       this.userInfoTable.put(userId,userInfo);
       return userInfo.toBuilder().id(userId).build();
    }
}
