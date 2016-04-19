package com.emedinaa.perutravel.data.datasource;

import android.util.Log;

import com.emedinaa.perutravel.data.datasource.PlaceDataSource;
import com.emedinaa.perutravel.data.datasource.request.ApiClient;
import com.emedinaa.perutravel.data.mapper.PlaceDataMapper;
import com.emedinaa.perutravel.data.model.PlaceResponse;
import com.emedinaa.perutravel.domain.model.Place;
import com.emedinaa.perutravel.domain.repository.RepositoryCallback;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by emedinaa on 16/04/16.
 */
public class RestPlaceDataSource implements PlaceDataSource {

    private static final String TAG = "RestPlaceDataS";
    private PlaceDataMapper placeDataMapper;
    private ApiClient.ServicesApiInterface servicesApiInterface;

    public RestPlaceDataSource(PlaceDataMapper placeDataMapper) {
        this.placeDataMapper = placeDataMapper;
        servicesApiInterface= ApiClient.getMyApiClient();
    }

    @Override
    public void loadPlaces(final RepositoryCallback repositoryCallback) {
        servicesApiInterface.places(new Callback<PlaceResponse>() {
            @Override
            public void success(PlaceResponse placeResponse, Response response) {
                if(placeResponse!=null) {
                    List<Place> places= placeDataMapper.transformResponse(placeResponse);
                    Log.v(TAG,"places "+places);
                    repositoryCallback.onSuccess(places);
                }else{
                    repositoryCallback.onError("");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                String message="";
                if(error!=null) {
                    message= error.getMessage();
                }
                Log.v(TAG,"error "+message);
                repositoryCallback.onError(message);
            }
        });
    }

}
