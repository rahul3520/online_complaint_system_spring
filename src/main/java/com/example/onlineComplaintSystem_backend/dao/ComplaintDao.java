package com.example.onlineComplaintSystem_backend.dao;

import com.example.onlineComplaintSystem_backend.model.Complaints;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ComplaintDao extends CrudRepository<Complaints,Integer> {

    @Query(value = "SELECT `id`, `complaint`, `user_id` FROM `complaints` WHERE `user_id`=:userId",nativeQuery = true)
    List<Complaints> UserComplaints(@Param("userId") String userId);


    @Query(value = "SELECT u.`address`,u.`dob`,u.`email_id`,u.`name`,u.`phone_no`,c.`complaint`\n" +
            "FROM `users` u JOIN complaints c \n" +
            "ON u.id = c.user_id",nativeQuery = true)
    List<Map<String,String>> AdminViewComplaints();
}
