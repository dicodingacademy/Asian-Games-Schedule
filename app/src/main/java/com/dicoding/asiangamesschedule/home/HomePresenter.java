package com.dicoding.asiangamesschedule.home;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.dicoding.asiangamesschedule.model.EventResponse;
import com.dicoding.asiangamesschedule.networking.ApiBuilder;
import com.dicoding.asiangamesschedule.networking.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {

    private final HomeView homeView;
    private final Context context;

    public HomePresenter(Context context, HomeView homeView) {
        this.context = context;
        this.homeView = homeView;
    }

    public void getEventList() {
        ApiService service = ApiBuilder.call();
        service.getEventList().enqueue(new Callback<List<EventResponse>>() {
            @Override
            public void onResponse(Call<List<EventResponse>> call, Response<List<EventResponse>> response) {
                homeView.setVisibilityProgressBar(View.GONE);
                homeView.getEventListSuccess(response);
            }

            @Override
            public void onFailure(Call<List<EventResponse>> call, Throwable t) {
                homeView.setVisibilityProgressBar(View.GONE);
            }
        });
    }
}
