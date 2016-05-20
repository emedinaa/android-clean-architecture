package com.emedinaa.perutravel.domain.interactor;

import com.emedinaa.perutravel.domain.model.Place;

import java.util.List;

/**
 * Created by emedinaa on 16/04/16.
 */
public interface PlaceCallback {

    void onPlaceSuccess(List<Place> places);
    void onPlaceError(String message);

}
