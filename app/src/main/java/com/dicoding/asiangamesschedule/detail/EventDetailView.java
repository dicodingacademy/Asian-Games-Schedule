package com.dicoding.asiangamesschedule.detail;

import com.dicoding.asiangamesschedule.model.EventResponse;

import java.util.List;

import retrofit2.Response;

public interface EventDetailView {

    void showProgressDialog();

    void hideProgressDialog();

    void setVisibilityNoData (int visibility);

    void getEventDetail(Response<EventResponse> response);
}
