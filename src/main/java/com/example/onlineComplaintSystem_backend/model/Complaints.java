package com.example.onlineComplaintSystem_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "complaints")
public class Complaints {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userId;

    private String complaint;

    public Complaints() {
    }

    public Complaints(int id, String userId, String complaint) {
        this.id = id;
        this.userId = userId;
        this.complaint = complaint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}
