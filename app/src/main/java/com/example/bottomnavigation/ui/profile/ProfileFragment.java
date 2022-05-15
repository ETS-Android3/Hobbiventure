package com.example.bottomnavigation.ui.profile;

import static android.content.ContentValues.TAG;

import android.app.Activity;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.databinding.FragmentProfileBinding;
import com.example.bottomnavigation.ui.search.CategoryFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {

    private Button button;
    private Button button2;
   // private Button button3;
    // private TextView textView;
    private EditText editText;
    private EditText editText2;



    private FragmentProfileBinding binding;

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String email = user.getEmail();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        editText = editText.findViewById(R.id.etUpdEmail);
        editText2 = editText.findViewById(R.id.etUpdPass);

        button = button.findViewById(R.id.updateEmail_btn);
        button2 = button2.findViewById(R.id.updatePass_btn);
        // button3 = (Button) button3.findViewById(R.id.button3);

        button.setOnClickListener(view -> {
            updEmail();
        });

        button2.setOnClickListener(view -> {
            updPassword();
        });

        /*button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettings();
            }
        });*/

        ProfileViewModel profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final Button button = binding.button3;
        final FragmentTransaction fr = getParentFragmentManager().beginTransaction();
        button.setOnClickListener(view -> {
            fr.replace(R.id.nav_host_fragment_activity_main,new SettingsFragment());
            fr.commit();
        });
        return root;


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /*public void openSettings(){
        Intent intent = new Intent(this, SettingsFragment.class);
        startActivity(intent);
    }*/


    public void updEmail(){
        Activity activity = getActivity();
        user.updateEmail(editText.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(activity, "Email successfully updated! ", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(activity, "Something went wrong... ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    public void updPassword(){
        Activity activity2 = getActivity();
        user.updatePassword(editText2.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(activity2, "Password successfully updated! ", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(activity2, "Something went wrong... ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }



}