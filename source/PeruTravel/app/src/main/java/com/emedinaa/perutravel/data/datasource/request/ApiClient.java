package com.emedinaa.perutravel.data.datasource.request;

import com.emedinaa.perutravel.BuildConfig;
import com.emedinaa.perutravel.data.model.BaseResponse;
import com.emedinaa.perutravel.data.model.PlaceResponse;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * Created by emedinaa on 16/04/16.
 */
public class ApiClient {

    private static final String TAG = "ApiClient";
    private static ServicesApiInterface servicesApiInterface;

    public static ServicesApiInterface getMyApiClient() {

        if (servicesApiInterface == null) {

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(BuildConfig.HOST)
                    .setClient(new OkClient(getClient()))
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();

            servicesApiInterface = restAdapter.create(ServicesApiInterface.class);
        }
        return servicesApiInterface;
    }

    public interface ServicesApiInterface {

        @Headers({
                "Content-Type: application/json",
                "application-id: DA9284B5-938D-38A8-FFB5-ED28F8E07A00",
                "secret-key: 513FB962-5397-99F4-FF6D-F56D4FAF9B00",
                "application-type: REST"
        })
        //
        @GET("/v1/data/Place")
        void places( Callback<PlaceResponse> callback);
    }

    private static OkHttpClient getClient() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(2, TimeUnit.MINUTES);
        client.setReadTimeout(2, TimeUnit.MINUTES);
        return client;
    }
}
