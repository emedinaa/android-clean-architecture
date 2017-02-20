package com.emedinaa.perutravel.presentation.presenter;

import android.os.Bundle;

import com.emedinaa.perutravel.domain.interactor.PlaceCallback;
import com.emedinaa.perutravel.domain.interactor.PlaceInteractor;
import com.emedinaa.perutravel.domain.model.Place;
import com.emedinaa.perutravel.presentation.view.MainView;

import java.util.List;

/**
 * Created by emedinaa on 16/04/16.
 */
public class PlacePresenter implements Presenter<MainView>, PlaceCallback{
    private static final String TAG = "PlacePresenter";
    private MainView mainView;
    private final PlaceInteractor placeInteractor;

    public PlacePresenter(PlaceInteractor placeInteractor) {
        this.placeInteractor = placeInteractor;
    }

    public void loadPlaces()
    {
        this.mainView.showLoading();
        placeInteractor.loadPlaces(this);
    }

    public void selectedPlace(Place place)
    {
        Bundle bundle= new Bundle();
        bundle.putSerializable("PLACE",place);
        this.mainView.gotoPlace(bundle);
    }

    @Override
    public void addView(MainView view) {
        this.mainView= view;
    }

    @Override
    public void removeView(MainView view) {
        this.mainView=null;
    }

    @Override
    public void onPlaceSuccess(List<Place> places) {
        this.mainView.hideLoading();
        this.mainView.renderPlaces(places);
    }

    @Override
    public void onPlaceError(String message) {
        this.mainView.hideLoading();
        this.mainView.showErrorMessage(message);
    }
}
