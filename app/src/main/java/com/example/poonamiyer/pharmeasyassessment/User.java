package com.example.poonamiyer.pharmeasyassessment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Poonam Iyer on 6/19/2018.
 */

public class User {
    @SerializedName("id")
    @Expose
    protected Integer id;
    @SerializedName("first_name")
    @Expose
    protected String firstName;
    @SerializedName("last_name")
    @Expose
    protected String lastName;
    @SerializedName("avatar")
    @Expose
    protected String avatar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
