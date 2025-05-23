package com.arfox.settings.fragments;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.Toast;
import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceChangeListener;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class ExtensionSettings extends SettingsPreferenceFragment implements Preference.OnPreferenceChangeListener {

    private static final String KEY_ARFOX_FLAVOUR = "arfox_flavour";
    private static final String PROP_GMS = "persist.sys.arfoxos.gms";

    @Override
    public int getMetricsCategory() {
        return 0;
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.extension_settings, rootKey);
        getActivity().setTitle(R.string.arfox_extension_settings_title);

        Preference flavourPref = findPreference(KEY_ARFOX_FLAVOUR);
        if (flavourPref != null) {
            flavourPref.setOnPreferenceClickListener(preference -> {
                Toast.makeText(getContext(), R.string.arfox_flavour_toast, Toast.LENGTH_SHORT).show();
                return true;
            });
            updateFlavourSummary(flavourPref);
        }
    }

    private void updateFlavourSummary(Preference preference) {
        int gmsValue = SystemProperties.getInt(PROP_GMS, 1);
        if (gmsValue == 1) {
            preference.setSummary(R.string.arfox_flavour_summary);
            preference.setIcon(R.drawable.ic_googleflavour);
        } else if (gmsValue == 2) {
            preference.setSummary(R.string.arfox_flavour_summary_vanilla);
            preference.setIcon(R.drawable.ic_vanillaflavour);
        }
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return false;
    }
} 