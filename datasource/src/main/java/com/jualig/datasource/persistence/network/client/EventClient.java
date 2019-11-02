package com.jualig.datasource.persistence.network.client;

import android.content.Context;

import com.jualig.datasource.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventClient extends ApiClient {
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private HttpLoggingInterceptor logging;
    private static EventClient themovieClient;

    public EventClient(Context context) {
        logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = getOkHttpClient(context);
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.addInterceptor(logging);
        //builder.addInterceptor(new ThemovieInterceptor(context));
        okHttpClient = builder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.URL)
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static EventClient getInstance(Context context) {
        if (themovieClient == null) {
            themovieClient = new EventClient(context);
        }
        return themovieClient;
    }

    @Override
    public <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
