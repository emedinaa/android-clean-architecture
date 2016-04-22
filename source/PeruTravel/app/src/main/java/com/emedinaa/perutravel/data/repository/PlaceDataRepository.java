package com.emedinaa.perutravel.data.repository;

import com.emedinaa.perutravel.data.datasource.PlaceDataStore;
import com.emedinaa.perutravel.data.datasource.PlaceDataStoreFactory;
import com.emedinaa.perutravel.data.mapper.PlaceDataMapper;
import com.emedinaa.perutravel.data.model.PlaceEntity;
import com.emedinaa.perutravel.data.model.PlaceResponse;
import com.emedinaa.perutravel.domain.interactor.PlaceCallback;
import com.emedinaa.perutravel.domain.model.Place;
import com.emedinaa.perutravel.domain.repository.PlaceRepository;
import com.emedinaa.perutravel.domain.repository.RepositoryCallback;

import java.util.List;

/**
 * Created by em on 22/04/16.
 */
public class PlaceDataRepository implements PlaceRepository {

    private static final String TAG = "UserDataRepository";
    private final PlaceDataStoreFactory placeDataStoreFactory;
    private final PlaceDataMapper placeDataMapper;

    public PlaceDataRepository(PlaceDataStoreFactory placeDataStoreFactory, PlaceDataMapper placeDataMapper) {
        this.placeDataStoreFactory = placeDataStoreFactory;
        this.placeDataMapper = placeDataMapper;
    }

    @Override
    public void loadPlaces(final PlaceCallback placeCallback) {
        final PlaceDataStore placeDataStore= this.placeDataStoreFactory.create(PlaceDataStoreFactory.CLOUD);
        placeDataStore.loadPlaces(new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if(object!=null){
                    message= object.toString();
                }
                placeCallback.onPlaceError(message);

            }

            @Override
            public void onSuccess(Object object) {
                //List<PlaceEntity> placeEntities= ((PlaceResponse)(object)).getData();
                PlaceResponse placeResponse= ((PlaceResponse)(object));

                List<Place> places= placeDataMapper.transformResponse(placeResponse);
                //List<Place> places= placeDataMapper.transformList(placeEntities);

                placeCallback.onPlaceSuccess(places);
            }
        });
    }
}
