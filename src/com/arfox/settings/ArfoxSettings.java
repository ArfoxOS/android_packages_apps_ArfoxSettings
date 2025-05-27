/*
 * Copyright (C) 2024-2025 The ArfoxOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package com.arfox.settings;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.Toast;
import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceChangeListener;

import com.android.internal.logging.nano.MetricsProto.MetricsEvent;
import com.android.settings.R;
import com.android.settings.dashboard.DashboardFragment;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settingslib.search.SearchIndexable;

@SearchIndexable
public class ArfoxSettings extends DashboardFragment implements Preference.OnPreferenceChangeListener {

    private static final String TAG = "ArfoxSettings";
    private static final String KEY_ARFOX_FLAVOUR = "arfox_flavour";
    private static final String PROP_GMS = "persist.sys.arfoxos.gms";

    @Override
    protected int getPreferenceScreenResId() {
        return R.xml.arfox_settings;
    }

    @Override
    public int getMetricsCategory() {
        return MetricsEvent.ARFOX;
    }

    @Override
    protected String getLogTag() {
        return TAG;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
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

    public static final BaseSearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
            new BaseSearchIndexProvider(R.xml.arfox_settings);
}
