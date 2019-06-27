package com.example.android.materialme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<DataSetList> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView sportsTitle = findViewById(R.id.titleDetail);
        ImageView sportsImage = findViewById(R.id.sportsImageDetail);
        sportsTitle.setText(getIntent().getStringExtra("title"));
        Glide.with(this).load(getIntent().getIntExtra("image_resource", 0))
                .into(sportsImage);

        String[] sportsList = getResources().getStringArray(R.array.sports_titles);
        String[] linkList = getResources().getStringArray(R.array.link);


        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        arrayList = new ArrayList<DataSetList>();

        DataSetList dataSetList = new DataSetList();

        for (int i=0;i<sportsList.length;i++){
            dataSetList = new DataSetList(linkList[i]);
            arrayList.add(dataSetList);}


        YoutubeAdapter youtubeAdapter = new YoutubeAdapter(arrayList,getApplicationContext());
        recyclerView.setAdapter(youtubeAdapter);

    }
}
