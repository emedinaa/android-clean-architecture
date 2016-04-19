package com.emedinaa.perutravel.domain.interactor;

import com.emedinaa.perutravel.domain.repository.PlaceRepository;

/**
 * Created by emedinaa on 16/04/16.
 */
public class PlaceInteractor {

    private final PlaceRepository placeRepository;

    public PlaceInteractor(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public void loadPlaces( final PlaceCallback placeCallback)
    {
        placeRepository.loadPlaces(placeCallback);
    }
}
