package com.example.bottomnavigation.ui.profile;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.databinding.FragmentProfileBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private Button button;
    private Button button2;
    // private TextView textView;
    private EditText editText;
    private EditText editText2;

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String email = user.getEmail();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        editText = editText.findViewById(R.id.etUpdEmail);
        editText2 = editText2.findViewById(R.id.etUpdPass);

        button = button.findViewById(R.id.updateEmail_btn);
        button2 = button2.findViewById(R.id.updatePass_btn);

        button.setOnClickListener(view -> {
            updEmail();
        });

        button2.setOnClickListener(view -> {
            updPassword();
        });

        ProfileViewModel profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void updEmail(){
        user.updateEmail(editText.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            //Toast.makeText(ProfileFragment.this, "Email successfully updated! ", Toast.LENGTH_SHORT).show();
                        }else{
                           // Toast.makeText(ProfileFragment.this, "Something went wrong... ", Toast.LENGTH_SHORT).show();
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
                            // Toast.makeText(ProfileFragment.this, "Password successfully updated! ", Toast.LENGTH_SHORT).show();
                        }else{
                           // Toast.makeText(ProfileFragment.this, "Something went wrong... ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}