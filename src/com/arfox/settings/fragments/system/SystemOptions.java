package com.arfox.settings.fragments.system;

import android.content.Intent;
import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.PreferenceCategory;
import android.os.Bundle;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class SystemOptions extends SettingsPreferenceFragment implements Preference.OnPreferenceChangeListener {

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
        setPreferencesFromResource(R.xml.arfox_system_settings, rootKey);

        getActivity().setTitle(R.string.arfox_system_options_title);
    }
}