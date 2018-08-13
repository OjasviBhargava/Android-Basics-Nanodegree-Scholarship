package com.example.ojasvi.punjabtourguide;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Ojasvi on 12-08-2018.
 */

public class JalandharActivity extends AppCompatActivity {
    private ArrayList<Attraction> attractions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_list);

        // Create a list of attractions
        attractions = new ArrayList<Attraction>();
        Location devi_talab = new Location(getResources().getString(R.string.jalandhar_attraction_name_1));
        devi_talab.setLatitude(24.13646);
        devi_talab.setLongitude(120.61139);
        attractions.add(new Attraction(getResources().getString(R.string.jalandhar_attraction_name_1), getResources().getString(R.string.jalandhar_attraction_phone_1), getResources().getString(R.string.jalandhar_attraction_address_1), getResources().getString(R.string.jalandhar_attraction_imageurl_1), devi_talab));

        Location science_city = new Location(getResources().getString(R.string.jalandhar_attraction_name_2));
        science_city.setLatitude(24.18486);
        science_city.setLongitude(120.60598);
        attractions.add(new Attraction(getResources().getString(R.string.jalandhar_attraction_name_2),
                getResources().getString(R.string.jalandhar_attraction_phone_2), getResources().getString(R.string.jalandhar_attraction_address_2),
                getResources().getString(R.string.jalandhar_attraction_imageurl_2), science_city));

        Location babaSodal = new Location(getResources().getString(R.string.jalandhar_attraction_name_3));
        babaSodal.setLatitude(24.35511);
        babaSodal.setLongitude(121.31046);
        attractions.add(new Attraction(getResources().getString(R.string.jalandhar_attraction_name_3),
                getResources().getString(R.string.jalandhar_attraction_phone_3), getResources().getString(R.string.jalandhar_attraction_address_3),
                getResources().getString(R.string.jalandhar_attraction_imageurl_3), babaSodal));

        Location modelTown = new Location(getResources().getString(R.string.jalandhar_attraction_name_4));
        modelTown.setLatitude(24.3117824);
        modelTown.setLongitude(120.5481198);
        attractions.add(new Attraction(getResources().getString(R.string.jalandhar_attraction_name_4),
                getResources().getString(R.string.jalandhar_attraction_phone_4), getResources().getString(R.string.jalandhar_attraction_address_4),
                getResources().getString(R.string.jalandhar_attraction_imageurl_4), modelTown));

        AttractionAdapter adapter = new AttractionAdapter(this, attractions);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = attractions.get(position).getLocation().getLatitude();
                double lon = attractions.get(position).getLocation().getLongitude();
                String keyword = attractions.get(position).getAttractionName();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(keyword));

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
    }
}
