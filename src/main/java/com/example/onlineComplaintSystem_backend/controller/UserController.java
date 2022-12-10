package com.example.onlineComplaintSystem_backend.controller;

import com.example.onlineComplaintSystem_backend.dao.UserDao;
import com.example.onlineComplaintSystem_backend.dao.UserDao;
import com.example.onlineComplaintSystem_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao udao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userRegistration",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> UserRegn(@RequestBody User u)
    {
        String name=String.valueOf(u.getName().toString());
        String dob=String.valueOf(u.getDob().toString());
        String address=String.valueOf(u.getAddress().toString());
        String phoneNo=String.valueOf(u.getPhoneNo().toString());
        String emailId=String.valueOf(u.getEmailId().toString());
        String password=String.valueOf(u.getPassword().toString());

        udao.save(u);

        HashMap<String,String> map=new HashMap<>();

        map.put("status","success");

        return map;

    }

    @CrossOrigin(origins="*")
    @PostMapping(path = "/userVerify",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> userCheck(@RequestBody User u)
    {
        String email=String.valueOf(u.getEmailId().toString());
        String pass=String.valueOf(u.getPassword().toString());

        List<User> userData= udao.userVerify(u.getEmailId(),u.getPassword());

        HashMap<String,String> map=new HashMap<>();

        if(userData.size()==0)
        {
            map.put("status","Invalid");

        }
        else
        {
            map.put("status","success");
            map.put("Id",String.valueOf(userData.get(0).getId()));
        }

        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/GetUserData",produces = "application/json",consumes = "application/json")
    public List<User> GetLoggedUserData(@RequestBody User u)
    {
        String userId=String.valueOf(u.getId());

        System.out.println(userId);

        return (List<User>) udao.GetuserData(u.getId());

    }
}
