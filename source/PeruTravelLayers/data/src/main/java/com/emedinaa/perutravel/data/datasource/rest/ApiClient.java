package com.emedinaa.perutravel.data.datasource.rest;

import com.emedinaa.perutravel.data.BuildConfig;
import com.emedinaa.perutravel.data.model.PlaceResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by emedinaa on 16/04/16.
 */
public class ApiClient {

    private static final String TAG = "ApiClient";
    private static ServicesApiInterface servicesApiInterface;
    private static OkHttpClient.Builder httpClient;



    public static ServicesApiInterface getMyApiClient() {

        if (servicesApiInterface == null) {

            Retrofit.Builder builder =new Retrofit.Builder()
                    .baseUrl(BuildConfig.API_URL)
                    .addConverterFactory(GsonConverterFactory.create());
            httpClient =new OkHttpClient.Builder();
            httpClient.addInterceptor(interceptor());

            Retrofit retrofit = builder.client(httpClient.build()).build();
            servicesApiInterface = retrofit.create(ServicesApiInterface.class);
        }
        return servicesApiInterface;
    }

    public interface ServicesApiInterface {

        @Headers({
                "Content-Type: application/json",
                "application-id: "+BuildConfig.APP_ID,
                "secret-key: "+BuildConfig.REST_KEY,
                "application-type: REST"
        })
        @GET("/v1/data/Place")
        Call<PlaceResponse> places();

        //Dynamic headers
        //Call<PlaceResponse> places(@HeaderMap Map<String, String> headers);
    }


    private  static HttpLoggingInterceptor interceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor= new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}
