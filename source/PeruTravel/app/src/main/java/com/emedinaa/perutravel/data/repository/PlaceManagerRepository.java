package com.emedinaa.perutravel.data.repository;

import com.emedinaa.perutravel.data.datasource.DbPlaceDataSource;
import com.emedinaa.perutravel.data.datasource.PlaceDataSource;
import com.emedinaa.perutravel.data.datasource.RestPlaceDataSource;
import com.emedinaa.perutravel.data.mapper.PlaceDataMapper;
import com.emedinaa.perutravel.domain.interactor.PlaceCallback;
import com.emedinaa.perutravel.domain.model.Place;
import com.emedinaa.perutravel.domain.repository.PlaceRepository;
import com.emedinaa.perutravel.domain.repository.RepositoryCallback;

import java.util.List;

/**
 * Created by emedinaa on 16/04/16.
 */
public class PlaceManagerRepository implements PlaceRepository {
    private final PlaceDataMapper placeDataMapper;

    public static final int PREFERENCES=0;
    public static final int DB=1;
    public static final int REST=2;
    private PlaceDataSource placeDataSource;

    public PlaceManagerRepository(PlaceDataMapper placeDataMapper) {
        this.placeDataMapper = placeDataMapper;
        build(REST);
    }

    public void build(int type)
    {
        switch (type)
        {
            case REST:
                placeDataSource= new RestPlaceDataSource(placeDataMapper);
                break;
            case DB:
                placeDataSource= new DbPlaceDataSource(placeDataMapper);
                break;
        }
    }

    @Override
    public void loadPlaces(final PlaceCallback placeCallback) {
        placeDataSource.loadPlaces(new RepositoryCallback() {
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
                List<Place> places= (List<Place>)(object);
                placeCallback.onPlaceSuccess(places);
            }
        });
    }
}
