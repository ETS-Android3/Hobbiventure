package com.example.bottomnavigation.ui.profile;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomnavigation.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String email = user.getEmail();
    private Button button;
    private TextView textView;
    private EditText editText;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        textView = textView.findViewById(R.id.tvCurrEmail);
        textView.setText(email);



    }

    public void updateEmail(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        editText = editText.findViewById(R.id.etUpdEmail);
        user.updateEmail(editText.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Email successfully updated!");
                        }
                    }
                });

    }

    public void updatePassword(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        editText = editText.findViewById(R.id.etUpdPass);
        user.updatePassword(editText.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Password successfully updated!");
                        }
                    }
                });

    }

}
