package com.example.bottomnavigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String FILE_NAME = "myFile";
    TextInputEditText etLoginEmail;
    TextInputEditText etLoginPassword;
    TextView tvRegisterHere;
    Button btnLogin;
    CheckBox rememberMe;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginEmail = findViewById(R.id.etLoginEmail);
        etLoginPassword = findViewById(R.id.etLoginPass);
        tvRegisterHere = findViewById(R.id.tvRegisterHere);
        btnLogin = findViewById(R.id.btnLogin);
        rememberMe = findViewById(R.id.rememberMe);
        mAuth = FirebaseAuth.getInstance();

        SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
      String email = preferences.getString("email", " ");
      String password = preferences.getString("password", " ");

      etLoginEmail.setText(email);
      etLoginPassword.setText(password);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etLoginEmail.getText().toString();
                String password1 = etLoginPassword.getText().toString();
                if (rememberMe.isChecked()) {
                    StoredDataUsingSharedPreference(email, password1);
                }
                loginUser();
            }
        });



        tvRegisterHere.setOnClickListener(view -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });


    }

    private void StoredDataUsingSharedPreference(String email, String password) {
        SharedPreferences.Editor editor = getSharedPreferences(FILE_NAME, MODE_PRIVATE).edit();
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();
    }


    public void loginUser() {
        String email = etLoginEmail.getText().toString();
        String password = etLoginPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            etLoginEmail.setError("Email cannot be empty");
            etLoginEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            etLoginPassword.setError("Password cannot be empty");
            etLoginPassword.requestFocus();
        } else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    } else {
                        Toast.makeText(LoginActivity.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
          //  startActivity(new Intent(this, LoginActivity.class));
        }
    }
}



