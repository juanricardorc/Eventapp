package com.jualig.datasource.repository.data;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.jualig.datasource.persistence.network.client.EventClient;
import com.jualig.datasource.persistence.network.response.EventResponse;
import com.jualig.datasource.persistence.network.service.EventService;
import com.jualig.datasource.repository.EventRepository;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventDataRepository implements EventRepository {
    private MutableLiveData<List<EventResponse>> eventMutableLiveData;
    private List<EventResponse> eventResponses;
    private Context context;

    public EventDataRepository(Context context) {
        this.context = context;
    }

    @Override
    public MutableLiveData<List<EventResponse>> getAll() {
        this.eventMutableLiveData = new MutableLiveData<>();
        this.eventResponses = new LinkedList<>();

        Call<List<EventResponse>> call = EventClient.getInstance(this.context)
                .createService(EventService.class).getAll();
        call.enqueue(new Callback<List<EventResponse>>() {
            @Override
            public void onResponse(Call<List<EventResponse>> call, Response<List<EventResponse>> response) {
                eventResponses = response.body();
                eventMutableLiveData.setValue(eventResponses);
            }

            @Override
            public void onFailure(Call<List<EventResponse>> call, Throwable t) {
                eventMutableLiveData.setValue(eventResponses);
            }
        });

        return this.eventMutableLiveData;
    }
}
