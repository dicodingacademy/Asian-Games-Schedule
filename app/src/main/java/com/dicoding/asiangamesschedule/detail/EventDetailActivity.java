package com.dicoding.asiangamesschedule.detail;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dicoding.asiangamesschedule.R;
import com.dicoding.asiangamesschedule.home.EventAdapter;
import com.dicoding.asiangamesschedule.home.HomeActivity;
import com.dicoding.asiangamesschedule.model.EventResponse;
import com.dicoding.asiangamesschedule.model.SubEvent;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;

public class EventDetailActivity extends AppCompatActivity implements EventDetailView, OnMapReadyCallback {
    private EventDetailPresenter presenter;
    private Context context;
    private int id;
    private String[] latLng;
    private String arenaName;
    private ProgressDialog progressDialog;

    @BindView(R.id.list_sub_event)
    RecyclerView subEventList;

    @BindView(R.id.headerImage)
    ImageView headerImage;

    @BindView(R.id.description)
    TextView textDescription;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.collapsingToolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.text_no_data)
    TextView textNoData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        id = getIntent().getIntExtra("id", 0);
        initializePresenter();

    }

    private void initializePresenter() {
        context = this;
        presenter = new EventDetailPresenter(context, this);
        presenter.getEventDetail(id);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProgressDialog() {
        progressDialog = loadingDialog(this);
    }

    @Override
    public void hideProgressDialog() {
        progressDialog.dismiss();
    }

    protected static ProgressDialog loadingDialog(Activity activity) {
        final ProgressDialog dialog = new ProgressDialog(activity);
        dialog.setMessage("Loading. Please wait...");
        dialog.setCancelable(false);
        dialog.show();
        return dialog;
    }

    @Override
    public void setVisibilityNoData (int visibility) {
        switch (visibility) {
            case View.GONE:
                textNoData.setVisibility(visibility);
                break;
            case View.VISIBLE:
                textNoData.setVisibility(visibility);
                break;
        }
    }

    @Override
    public void getEventDetail(Response<EventResponse> response) {
        latLng = response.body().getArenas().get(0).getAddress().split(",");
        arenaName = response.body().getArenas().get(0).getName();
        collapsingToolbarLayout.setTitle(response.body().getName());
        collapsingToolbarLayout.setExpandedTitleMargin(50,50,250,50);
        Glide.with(context)
                .load(response.body().getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .skipMemoryCache(true)
                .into(headerImage);
        textDescription.setText(response.body().getDescription());
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_view);
        mapFragment.getMapAsync(EventDetailActivity.this);

        SubEventAdapter adapter = new SubEventAdapter(getApplicationContext(), response.body().getSubEvents(), new SubEventAdapter.OnItemClickListener() {
            @Override
            public void onClick(SubEvent Item) {
                Intent intent = new Intent(EventDetailActivity.this, EventDetailActivity.class);
                intent.putExtra("id", Item.getId());
                startActivity(intent);
            }
        });
        subEventList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        subEventList.setAdapter(adapter);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (latLng!=null){
            LatLng location = new LatLng(Double.parseDouble(latLng[0]), Double.parseDouble(latLng[1]));
            googleMap.addMarker(new MarkerOptions().position(location).title(arenaName));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(location));
            googleMap.animateCamera( CameraUpdateFactory.zoomTo( 13.0f ) );
        }
    }
}
