package com.emedinaa.perutravel.data.datasource;

import com.emedinaa.perutravel.data.mapper.PlaceDataMapper;
import com.emedinaa.perutravel.domain.repository.RepositoryCallback;

/**
 * Created by emedinaa on 16/04/16.
 */
public class DbPlaceDataSource implements PlaceDataSource {
    private PlaceDataMapper placeDataMapper;

    public DbPlaceDataSource(PlaceDataMapper placeDataMapper) {
        this.placeDataMapper = placeDataMapper;
    }


    @Override
    public void loadPlaces(RepositoryCallback repositoryCallback) {

    }
}
