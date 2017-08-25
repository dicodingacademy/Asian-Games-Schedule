package com.dicoding.asiangamesschedule.networking;

import com.dicoding.asiangamesschedule.model.EventResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("v2/program/testCustomer/events")
    Call<List<EventResponse>> getEventList();

    @GET("v2/program/testCustomer/events/{eventid}")
    Call<EventResponse> getEventById(@Path("eventid") int eventid);

}
