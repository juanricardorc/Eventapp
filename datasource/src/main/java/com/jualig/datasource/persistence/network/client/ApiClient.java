package com.jualig.datasource.persistence.network.client;

import android.content.Context;

import okhttp3.OkHttpClient;

public abstract class ApiClient {
    public abstract <S> S createService(Class<S> serviceClass);
    public OkHttpClient.Builder getOkHttpClient(Context context) {
        return new OkHttpClient.Builder();
    }
}
