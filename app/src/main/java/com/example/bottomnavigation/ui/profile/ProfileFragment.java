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

import com.example.bottomnavigation.LoginActivity;
import com.example.bottomnavigation.MainActivity;
import com.example.bottomnavigation.R;
import com.example.bottomnavigation.RegisterActivity;
import com.example.bottomnavigation.databinding.FragmentProfileBinding;
import com.example.bottomnavigation.ui.search.CategoryFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private ProfileViewModel profileViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final Button button = binding.button3;
        final Button button2 = binding.updateEmailBtn;
        final Button button3 = binding.updatePassBtn;
        final Button button4 = binding.buttonSgnout;
        final EditText editText = binding.etUpdEmail;
        final EditText editText1 = binding.etUpdPass;
        final FragmentTransaction fr = getParentFragmentManager().beginTransaction();
        button.setOnClickListener(view -> {
            fr.replace(R.id.nav_host_fragment_activity_main,new SettingsFragment());
            fr.commit();
        });

      button4.setOnClickListener(view -> {
          FirebaseAuth.getInstance().signOut();
          moveToLoginActivity();
        });

        button2.setOnClickListener(view -> {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            user.updateEmail(editText.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getContext(), "Email successfully updated!", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(getContext(), "Email update error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            editText.setText("");
        });

        button3.setOnClickListener(view -> {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            user.updatePassword(editText1.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                               Toast.makeText(getContext(), "Password successfully updated!", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(getContext(), "Password update error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
            editText1.setText("");
        });
        return root;

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void moveToLoginActivity () {
        Intent i = new Intent(getActivity(), LoginActivity.class);
        startActivity(i);
        ((Activity) getActivity()).overridePendingTransition(0, 0);

    }

}