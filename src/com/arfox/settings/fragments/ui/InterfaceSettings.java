package com.arfox.settings.fragments.ui;

import android.content.Intent;
import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.PreferenceCategory;
import androidx.preference.SwitchPreference;
import android.os.Bundle;
import android.os.SystemProperties;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class InterfaceSettings extends SettingsPreferenceFragment implements Preference.OnPreferenceChangeListener {

    private static final String KEY_EXPRESSIVE_DESIGN = "expressive_design";
    private static final String PROP_EXPRESSIVE_DESIGN = "persist.sys.arfox.is_expressive_design_enabled";

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (preference.getKey().equals(KEY_EXPRESSIVE_DESIGN)) {
            boolean value = (Boolean) newValue;
            SystemProperties.set(PROP_EXPRESSIVE_DESIGN, value ? "1" : "0");
            return true;
        }
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

        SwitchPreference expressiveDesign = findPreference(KEY_EXPRESSIVE_DESIGN);
        if (expressiveDesign != null) {
            expressiveDesign.setChecked(SystemProperties.getBoolean(PROP_EXPRESSIVE_DESIGN, false));
            expressiveDesign.setOnPreferenceChangeListener(this);
        }
    }
}
