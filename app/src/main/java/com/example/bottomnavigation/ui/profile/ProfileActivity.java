package com.example.bottomnavigation.ui.profile;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomnavigation.LoginActivity;
import com.example.bottomnavigation.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {



    private Button button;
    private Button button2;
    private Button button3;
   // private TextView textView;
    private EditText editText;
    private EditText editText2;

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String email = user.getEmail();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        editText = editText.findViewById(R.id.etUpdEmail);
        editText2 = editText.findViewById(R.id.etUpdPass);

        button = button.findViewById(R.id.updateEmail_btn);
        button2 = button2.findViewById(R.id.updatePass_btn);
        button3 = (Button) button3.findViewById(R.id.button3);

        button.setOnClickListener(view -> {
            updEmail();
        });

        button2.setOnClickListener(view -> {
            updPassword();
        });


    }




    public void updEmail(){
        user.updateEmail(editText.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ProfileActivity.this, "Email successfully updated! ", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(ProfileActivity.this, "Something went wrong... ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    public void updPassword(){
        user.updatePassword(editText2.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ProfileActivity.this, "Password successfully updated! ", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(ProfileActivity.this, "Something went wrong... ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

}
