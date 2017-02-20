package com.emedinaa.perutravel.presentation.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.emedinaa.perutravel.R;
import com.emedinaa.perutravel.data.datasource.PlaceDataStoreFactory;
import com.emedinaa.perutravel.data.mapper.PlaceDataMapper;
import com.emedinaa.perutravel.data.repository.PlaceDataRepository;
import com.emedinaa.perutravel.domain.interactor.PlaceInteractor;
import com.emedinaa.perutravel.domain.model.Place;
import com.emedinaa.perutravel.domain.repository.PlaceRepository;
import com.emedinaa.perutravel.presentation.adapter.PlaceAdapter;
import com.emedinaa.perutravel.presentation.presenter.PlacePresenter;
import com.emedinaa.perutravel.presentation.ui.recycler.MarginDecoration;
import com.emedinaa.perutravel.presentation.ui.recycler.RecyclerClickListener;
import com.emedinaa.perutravel.presentation.ui.recycler.RecyclerTouchListener;
import com.emedinaa.perutravel.presentation.view.MainView;

import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements MainView {

    private static final String TAG ="MainActivity";

    @Bind(R.id.flayProgress)View flayProgress;
    @Bind(R.id.container)View container;
    @Bind(R.id.rvPlace)RecyclerView rvPlace;

    private PlacePresenter placePresenter;
    private PlaceAdapter placeAdapter;
    private List<Place> places;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        injectView();
        setupPresenter();
        ui();

        loadPlaces();
    }

    private void setupPresenter() {
        PlaceRepository placeRepository= new PlaceDataRepository(new PlaceDataStoreFactory(getApplicationContext()),new PlaceDataMapper());
        PlaceInteractor placeInteractor= new PlaceInteractor(placeRepository);
        placePresenter= new PlacePresenter(placeInteractor);
        placePresenter.addView(this);
    }

    private void loadPlaces() {
        placePresenter.loadPlaces();
    }

    private void ui() {
        rvPlace.setHasFixedSize(false);
        rvPlace.addItemDecoration(new MarginDecoration(this));
        rvPlace.setLayoutManager(new LinearLayoutManager(this));

        rvPlace.addOnItemTouchListener(new RecyclerTouchListener(this, rvPlace, new RecyclerClickListener() {
            @Override
            public void onClick(View view, int position) {
                if(places!=null) {
                    Place place= places.get(position);
                    placePresenter.selectedPlace(place);
                }
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
    }

    @Override
    public void showLoading() {
        flayProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        flayProgress.setVisibility(View.GONE);
    }

    @Override
    public void renderPlaces(List<Place> places) {
        Log.v(TAG, "renderplaces " + places+" size "+places.size());
        this.places= places;
        placeAdapter= new PlaceAdapter(places);
        rvPlace.setAdapter(placeAdapter);
    }

    @Override
    public void showErrorMessage(String message) {
        showMessage(container,message);
    }

    @Override
    public void gotoPlace(Bundle bundle) {
        next(bundle,PlaceActivity.class,false);
    }

    @Override
    protected void onDestroy() {
        if(placePresenter!=null){placePresenter.removeView(this);}
        super.onDestroy();
    }
}
