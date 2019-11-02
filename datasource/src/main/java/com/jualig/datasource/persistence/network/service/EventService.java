package com.jualig.datasource.persistence.network.service;

import com.jualig.datasource.persistence.network.response.EventResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EventService {

    @GET("event")
    Call<List<EventResponse>> getAll();
}
