package com.jualig.eventapp.event;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.jualig.datasource.persistence.network.response.EventResponse;
import com.jualig.datasource.repository.EventRepository;
import com.jualig.datasource.repository.data.EventDataRepository;

import java.util.List;

public class EventViewModel extends AndroidViewModel {
    private EventRepository eventRepository;

    public EventViewModel(@NonNull Application application) {
        super(application);
        this.eventRepository = new EventDataRepository(application);
    }

    public LiveData<List<EventResponse>> getAll() {
        return this.eventRepository.getAll();
    }
}
