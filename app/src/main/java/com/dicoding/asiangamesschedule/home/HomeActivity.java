package com.dicoding.asiangamesschedule.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.dicoding.asiangamesschedule.R;
import com.dicoding.asiangamesschedule.detail.EventDetailActivity;
import com.dicoding.asiangamesschedule.model.EventResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeView {
    @BindView(R.id.list_event)
    RecyclerView eventList;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private HomePresenter presenter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initializePresenter();
    }

    private void initializePresenter() {
        context = this;
        presenter = new HomePresenter(context, this);
        presenter.getEventList();
    }

    @Override
    public void setVisibilityProgressBar(int visibility) {
        switch (visibility) {
            case View.GONE:
                progressBar.setVisibility(visibility);
                eventList.setVisibility(View.VISIBLE);
                eventList.scrollToPosition(0);
                break;
            case View.VISIBLE:
                progressBar.setVisibility(visibility);
                eventList.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void getEventListSuccess(final retrofit2.Response<List<EventResponse>> response) {
        EventAdapter adapter = new EventAdapter(getApplicationContext(), response.body(), new EventAdapter.OnItemClickListener() {
            @Override
            public void onClick(EventResponse Item) {
                Intent intent = new Intent(HomeActivity.this, EventDetailActivity.class);
                intent.putExtra("id", Item.getId());
                startActivity(intent);
            }
        });
        eventList.setLayoutManager(new LinearLayoutManager(this));
        eventList.setAdapter(adapter);
    }
}
