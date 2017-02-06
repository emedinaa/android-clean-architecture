package com.emedinaa.perutravel.data.datasource.rest;

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
    private static final String API_BASE_URL="http://api.backendless.com";
    private static ServicesApiInterface servicesApiInterface;
    private static OkHttpClient.Builder httpClient;



    public static ServicesApiInterface getMyApiClient() {

        if (servicesApiInterface == null) {

            Retrofit.Builder builder =new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
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
                "application-id: E324073C-E9A4-FE14-FFFE-BFDA5C701700",
                "secret-key: 169F9E06-12BA-4B02-FF83-C97E29C5BE00",
                "application-type: REST"
        })
        //
        @GET("/v1/data/Place")
        Call<PlaceResponse> places();
    }


    private  static HttpLoggingInterceptor interceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor= new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}
