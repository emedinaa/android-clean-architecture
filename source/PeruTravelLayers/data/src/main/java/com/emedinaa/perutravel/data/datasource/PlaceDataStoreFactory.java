package com.emedinaa.perutravel.data.datasource;

import android.content.Context;

import com.emedinaa.perutravel.data.datasource.db.DbPlaceDataStore;
import com.emedinaa.perutravel.data.datasource.preferences.PreferencesPlaceDataStore;
import com.emedinaa.perutravel.data.datasource.rest.RestPlaceDataStore;

/**
 * Created by em on 22/04/16.
 */
public class PlaceDataStoreFactory {

    public static final  int DB=1;
    public static final  int CLOUD=2;
    public static final  int PREFERENCES=3;

    private final Context context;

    public PlaceDataStoreFactory(Context context) {

        if (context == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
        }
        this.context = context;
    }

    public PlaceDataStore create(int dataSource)
    {
        PlaceDataStore placeDataStore=null;

        switch (dataSource)
        {
            case CLOUD:
                placeDataStore= createCloudDataStore();
                break;
            case DB:
                placeDataStore= new DbPlaceDataStore();
                break;
            case PREFERENCES:
                placeDataStore= new PreferencesPlaceDataStore(context);
                break;
        }
        return placeDataStore;
    }


    public PlaceDataStore createCloudDataStore() {

        return new RestPlaceDataStore();
    }
}
