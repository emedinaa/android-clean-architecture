package com.emedinaa.perutravel.domain.repository;

import com.emedinaa.perutravel.domain.interactor.PlaceCallback;
import com.emedinaa.perutravel.domain.model.Place;

import java.util.List;

/**
 * Created by emedinaa on 16/04/16.
 */
public interface PlaceRepository {

    void loadPlaces(final PlaceCallback placeCallback);
}
