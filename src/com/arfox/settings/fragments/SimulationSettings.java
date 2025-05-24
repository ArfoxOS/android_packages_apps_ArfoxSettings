package com.arfox.settings.fragments;

import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.SwitchPreference;
import android.os.SystemProperties;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class SimulationSettings extends SettingsPreferenceFragment implements Preference.OnPreferenceChangeListener {

    private static final String KEY_UNLIMITED_GPHOTOS = "unlimited_gphotos";
    private static final String KEY_PIXEL_FEATURES = "pixel_features";
    private static final String PROP_UNLIMITED_GPHOTOS = "persist.sys.sih.unlimited_gphotos";
    private static final String PROP_PIXEL_FEATURES = "persist.sys.sih.pixel_features";

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (preference.getKey().equals(KEY_UNLIMITED_GPHOTOS)) {
            boolean value = (Boolean) newValue;
            SystemProperties.set(PROP_UNLIMITED_GPHOTOS, value ? "true" : "false");
            return true;
        } else if (preference.getKey().equals(KEY_PIXEL_FEATURES)) {
            boolean value = (Boolean) newValue;
            SystemProperties.set(PROP_PIXEL_FEATURES, value ? "true" : "false");
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
        setPreferencesFromResource(R.xml.simulation_settings, rootKey);
        getActivity().setTitle(R.string.arfox_simulation_title);

        SwitchPreference unlimitedGphotos = findPreference(KEY_UNLIMITED_GPHOTOS);
        if (unlimitedGphotos != null) {
            unlimitedGphotos.setChecked(SystemProperties.getBoolean(PROP_UNLIMITED_GPHOTOS, false));
            unlimitedGphotos.setOnPreferenceChangeListener(this);
        }

        SwitchPreference pixelFeatures = findPreference(KEY_PIXEL_FEATURES);
        if (pixelFeatures != null) {
            pixelFeatures.setChecked(SystemProperties.getBoolean(PROP_PIXEL_FEATURES, false));
            pixelFeatures.setOnPreferenceChangeListener(this);
        }
    }
} 