package com.emedinaa.perutravel.data.datasource.rest;

import com.emedinaa.perutravel.data.datasource.PlaceDataStore;
import com.emedinaa.perutravel.data.model.PlaceResponse;
import com.emedinaa.perutravel.domain.repository.RepositoryCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by emedinaa on 16/04/16.
 */
public class RestPlaceDataStore implements PlaceDataStore {

    private static final String TAG = "RestPlaceDataS";
    private ApiClient.ServicesApiInterface servicesApiInterface;

    public RestPlaceDataStore() {
        servicesApiInterface= ApiClient.getMyApiClient();
    }

    @Override
    public void loadPlaces(final RepositoryCallback repositoryCallback) {

        Call<PlaceResponse> call= servicesApiInterface.places();
        call.enqueue(new Callback<PlaceResponse>() {
            @Override
            public void onResponse(Call<PlaceResponse> call, Response<PlaceResponse> response) {
                if(response.isSuccessful()){
                    PlaceResponse placeResponse= response.body();
                    if(placeResponse!=null){
                        repositoryCallback.onSuccess(placeResponse);
                    }else{
                        repositoryCallback.onError("");
                    }
                }else{
                    repositoryCallback.onError("");
                }
            }

            @Override
            public void onFailure(Call<PlaceResponse> call, Throwable t) {
                String message;
                try {
                    message= new StringBuffer().append(t.getMessage()).toString();
                }catch (NullPointerException e) {
                    message=e.getMessage();
                }
                repositoryCallback.onError(message);
            }
        });

    }

}
