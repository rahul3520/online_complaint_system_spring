package com.example.onlineComplaintSystem_backend.controller;


import com.example.onlineComplaintSystem_backend.dao.ComplaintDao;
import com.example.onlineComplaintSystem_backend.model.Complaints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ComplaintController {

    @Autowired
    private ComplaintDao cdao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addComplaint",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> AddComplaint(@RequestBody Complaints c)
    {
        String userId=String.valueOf(c.getUserId().toString());
        String complaint=String.valueOf(c.getComplaint().toString());

        System.out.println(userId);
        System.out.println(complaint);

        cdao.save(c);

        HashMap<String,String> map=new HashMap<>();

        map.put("status","success");

        return map;
    }
}
