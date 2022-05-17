package com.example.bottomnavigation.ui.profile;

import android.os.Bundle;

import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceFragmentCompat;

import com.example.bottomnavigation.R;

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