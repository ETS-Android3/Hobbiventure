package com.example.bottomnavigation.ui.profile;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileInfo {

    private FirebaseAuth firebaseAuth;
    FirebaseUser user = firebaseAuth.getCurrentUser();

    private String email = user.getDisplayName();


    public ProfileInfo(String email, String password) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

}
