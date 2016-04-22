package com.emedinaa.perutravel.presentation.presenter;

import android.os.Bundle;
import android.util.Log;

import com.emedinaa.perutravel.data.datasource.PlaceDataStoreFactory;
import com.emedinaa.perutravel.data.mapper.PlaceDataMapper;
import com.emedinaa.perutravel.data.repository.PlaceDataRepository;
import com.emedinaa.perutravel.domain.interactor.PlaceCallback;
import com.emedinaa.perutravel.domain.interactor.PlaceInteractor;
import com.emedinaa.perutravel.domain.model.Place;
import com.emedinaa.perutravel.domain.repository.PlaceRepository;
import com.emedinaa.perutravel.presentation.view.MainView;

import java.util.List;

/**
 * Created by emedinaa on 16/04/16.
 */
public class PlacePresenter implements Presenter<MainView>, PlaceCallback{
    private static final String TAG = "PlacePresenter";
    private MainView mainView;
    private PlaceInteractor placeInteractor;

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
        //PlaceRepository placeRepository= new PlaceManagerRepository(new PlaceDataMapper());
        PlaceRepository placeRepository= new PlaceDataRepository(new PlaceDataStoreFactory(this.mainView.getContext()),new PlaceDataMapper());
        placeInteractor= new PlaceInteractor(placeRepository);
    }

    @Override
    public void removeView(MainView view) {
        this.mainView=null;
    }

    @Override
    public void onPlaceSuccess(List<Place> places) {
        Log.v(TAG, "onPlaceSuccess " + places);
        this.mainView.hideLoading();
        this.mainView.renderPlaces(places);
    }

    @Override
    public void onPlaceError(String message) {
        this.mainView.hideLoading();
        this.mainView.showErrorMessage(message);
    }
}
