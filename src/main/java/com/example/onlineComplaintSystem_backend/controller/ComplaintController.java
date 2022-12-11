package com.example.onlineComplaintSystem_backend.controller;


import com.example.onlineComplaintSystem_backend.dao.ComplaintDao;
import com.example.onlineComplaintSystem_backend.model.Complaints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewUserComplaint",produces = "application/json",consumes = "application/json")
    public List<Complaints> ViewMyComplaint(@RequestBody Complaints c)
    {
        String uid=String.valueOf(c.getUserId());
        System.out.println(uid);

        return(List<Complaints>) cdao.UserComplaints(c.getUserId());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewAllComplaint")
    public List<Map<String,String>> ViewAllComplaints()
    {
        return (List<Map<String, String>>) cdao.AdminViewComplaints();
    }


}
