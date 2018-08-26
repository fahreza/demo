package com.apps.id.rijks.networking;

import com.apps.id.rijks.BuildConfig;
import com.apps.id.rijks.model.ArtResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by fahrezafauzi on 8/26/18.
 */

public class RestClient {
    private static final int CONNECTION_TIME_OUT = 90;
    private static ApiService mApiService;

    public static ApiService getClient() {
        if (mApiService == null) {
            final OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
                    .readTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.HOSTNAME)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient.build())
                    .build();
            mApiService = retrofit.create(ApiService.class);
        }
        return mApiService;
    }

    public interface ApiService {
        @GET(ApiUrl.LIST_ART)
        Call<ArtResponse> getArtList();
    }

}
