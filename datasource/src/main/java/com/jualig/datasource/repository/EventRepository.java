package com.jualig.datasource.repository;

import androidx.lifecycle.MutableLiveData;

import com.jualig.datasource.persistence.network.response.EventResponse;

import java.util.List;

public interface EventRepository {
    MutableLiveData<List<EventResponse>> getAll();
}
