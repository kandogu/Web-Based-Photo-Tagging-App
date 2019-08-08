package com.tagphoto.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.ArrayList;

@Document
public class Photo {

    @Id
    private long Id;
    private String address;
    private ArrayList<String> tagList = new ArrayList<>();
    private String assignedTo = "";

    public Photo() {
    }

    ;

    public Photo(long id, String address) {
        this.Id = id;
        this.address = address;
    }

    public void addTag(String newTag) {
        if (!tagList.contains(newTag))
            tagList.add(newTag);
    }

    //getters
    public Long getId() {
        return this.Id;
    }

    //setters
    public void setId(Long id) {
        this.Id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<String> getTag() {
        return tagList;
    }

    public void setAssignedTo(String username) {
        assignedTo = username;
    }
}
