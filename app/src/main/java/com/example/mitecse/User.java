package com.example.mitecse;



class User {
    public String email , password ,phone, dob;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String email,  String password,String phone, String dob) {
        this.email = email;
        this.password =password;
        this.phone = phone;
        this.dob = dob;
    }
}

