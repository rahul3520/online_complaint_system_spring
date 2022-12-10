package com.example.onlineComplaintSystem_backend.dao;

import com.example.onlineComplaintSystem_backend.model.Complaints;
import org.springframework.data.repository.CrudRepository;

public interface ComplaintDao extends CrudRepository<Complaints,Integer> {


}
