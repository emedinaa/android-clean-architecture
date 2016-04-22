package com.emedinaa.perutravel.data.datasource.preferences;

import android.content.Context;

import com.emedinaa.perutravel.data.datasource.PlaceDataStore;
import com.emedinaa.perutravel.domain.repository.RepositoryCallback;

/**
 * Created by em on 22/04/16.
 */
public class PreferencesPlaceDataStore implements PlaceDataStore {

    private final Context context;
    public PreferencesPlaceDataStore(Context context) {
        this.context= context;
    }

    @Override
    public void loadPlaces(RepositoryCallback repositoryCallback) {

    }
}
