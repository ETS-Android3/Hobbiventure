package com.example.bottomnavigation.ui.profile;

import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileViewModel extends ViewModel {

    //private final MutableLiveData<String> mText;
    private EditText editText;
    private EditText editText1;


    public ProfileViewModel() {
       /* this.editText = editText;
        this.editText1 = editText;
        mText = new MutableLiveData<>();
        mText.setValue("This is profile fragment"); */
    }



    public void updEmail(){
        /*FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        user.updateEmail(editText.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // Toast.makeText(this, ProfileFragment, "Email successfully updated! ", Toast.LENGTH_SHORT).show();
                        }else{
                            // Toast.makeText(activity, "Something went wrong... ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/

    }

    public void updPassword(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        /*user.updatePassword(editText1.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                         //   Toast.makeText(ProfileFragment, "Password successfully updated! ", Toast.LENGTH_SHORT).show();
                        }else{
                          //  Toast.makeText(ProfileFragment, "Something went wrong... ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/

    }

}