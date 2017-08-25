package com.dicoding.asiangamesschedule.home;

import com.dicoding.asiangamesschedule.model.EventResponse;

import java.util.List;

import retrofit2.Response;

public interface HomeView {

    void setVisibilityProgressBar(int visibility);

    void getEventListSuccess(Response<List<EventResponse>> response);
}
