package com.arfox.settings.fragments.ui;

import android.content.Intent;
import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.PreferenceCategory;
import android.os.Bundle;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;


public class InterfaceSettings extends SettingsPreferenceFragment implements Preference.OnPreferenceChangeListener {

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return false;
    }

    @Override
    public int getMetricsCategory() {
        return 0;
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.interface_settings, rootKey);

        getActivity().setTitle(R.string.arfox_interface_title);
    }
}
