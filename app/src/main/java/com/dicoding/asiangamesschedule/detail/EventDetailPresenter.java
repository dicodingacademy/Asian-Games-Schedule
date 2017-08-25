package com.dicoding.asiangamesschedule.detail;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.dicoding.asiangamesschedule.model.EventResponse;
import com.dicoding.asiangamesschedule.networking.ApiBuilder;
import com.dicoding.asiangamesschedule.networking.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventDetailPresenter {

    private final EventDetailView view;
    private final Context context;

    public EventDetailPresenter(Context context, EventDetailView view) {
        this.context = context;
        this.view = view;
    }

    public void getEventDetail(int id) {
        view.showProgressDialog();
        ApiService service = ApiBuilder.call();
        service.getEventById(id).enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                view.hideProgressDialog();
                view.getEventDetail(response);
                if (response.body().getSubEvents().size() != 0){
                    view.setVisibilityNoData(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                view.hideProgressDialog();
            }
        });
    }
}
