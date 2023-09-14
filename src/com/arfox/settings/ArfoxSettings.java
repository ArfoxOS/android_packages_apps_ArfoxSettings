/*
 * Copyright (C) 2024-2025 The ArfoxOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package com.arfox.settings;

import com.android.internal.logging.nano.MetricsProto.MetricsEvent;
import com.android.settings.R;
import com.android.settings.dashboard.DashboardFragment;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settingslib.search.SearchIndexable;

@SearchIndexable
public class ArfoxSettings extends DashboardFragment {

    private static final String TAG = "ArfoxSettings";

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

    public static final BaseSearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
            new BaseSearchIndexProvider(R.xml.arfox_settings);
}
