package com.jualig.eventapp.event;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jualig.datasource.persistence.network.response.EventResponse;
import com.jualig.datasource.repository.model.Event;
import com.jualig.eventapp.R;
import com.jualig.eventapp.event.adapter.EventRecyclerViewAdapter;

import java.util.LinkedList;
import java.util.List;

public class EventFragment extends Fragment {

    private Toolbar toolbar;
    private RecyclerView eventRecyclerView;
    private EventRecyclerViewAdapter adapter;
    private List<Event> events;
    private EventViewModel eventViewModel;

    public EventFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        finds(view);
        return view;
    }

    private void finds(View view) {
        setupToolbar(view, "Eventos", "", false);
        this.eventRecyclerView = view.findViewById(R.id.menu_recycler_view);
        this.events = new LinkedList<>();
    }

    private void setupToolbar(View view, String title, String subTitle, boolean arrow) {
        this.toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(this.toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle(subTitle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(arrow);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadEvents();
    }

    private void loadEvents() {
        ViewModelProviders.of(this).get(EventViewModel.class).getAll()
                .observe(this, new Observer<List<EventResponse>>() {
                    @Override
                    public void onChanged(List<EventResponse> eventResponses) {
                        setMenuRecyclerView(eventResponses);
                    }
                });
    }

    private void setMenuRecyclerView(List<EventResponse> eventResponses) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.eventRecyclerView.setLayoutManager(linearLayoutManager);
        this.adapter = new EventRecyclerViewAdapter(eventResponses, R.layout.event_cardview, getActivity());
        this.eventRecyclerView.setAdapter(this.adapter);
    }
}
