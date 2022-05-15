package com.example.bottomnavigation.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.PreferenceFragmentCompat;

import com.example.bottomnavigation.R;
import com.example.bottomnavigation.databinding.FragmentSearchBinding;
import com.example.bottomnavigation.ui.search.CategoryFragment;
import com.example.bottomnavigation.ui.search.SearchViewModel;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        final FragmentTransaction fr = getParentFragmentManager().beginTransaction();
        fr.detach(SettingsFragment.this);
        fr.commit();
    }
}