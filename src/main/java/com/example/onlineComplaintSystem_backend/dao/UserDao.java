package com.example.onlineComplaintSystem_backend.dao;

import com.example.onlineComplaintSystem_backend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<User,Integer> {

    @Query(value = "SELECT `id`, `address`, `dob`, `email_id`, `name`, `password`, `phone_no` FROM `users` WHERE `email_id`=:emailId AND `password`=:password",nativeQuery = true)
    List<User> userVerify(@Param("emailId") String emailId,@Param("password") String password);

    @Query(value = "SELECT `id`, `address`, `dob`, `email_id`, `name`, `password`, `phone_no` FROM `users` WHERE `id`=:Id",nativeQuery = true)
    List<User> GetuserData(@Param("Id") int Id);

}
