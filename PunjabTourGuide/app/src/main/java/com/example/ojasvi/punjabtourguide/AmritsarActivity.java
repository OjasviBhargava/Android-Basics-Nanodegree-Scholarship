package com.example.ojasvi.punjabtourguide;

/**
 * Created by Ojasvi on 12-08-2018.
 */
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
public class AmritsarActivity extends AppCompatActivity {
    private ArrayList<Attraction> attractions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_list);

        // Create a list of attractions
        attractions = new ArrayList<Attraction>();
        Location amritsar_golden_temple = new Location(getResources().getString(R.string.amritsar_attraction_name_1));
        amritsar_golden_temple.setLatitude(22.61023);
        amritsar_golden_temple.setLongitude(120.30174);
        attractions.add(new Attraction(getResources().getString(R.string.amritsar_attraction_name_1),
                getResources().getString(R.string.amritsar_attraction_phone_1), getResources().getString(R.string.amritsar_attraction_address_1),
                getResources().getString(R.string.amritsar_attraction_imageurl_1), amritsar_golden_temple));

        Location amritsar_jal_bagh = new Location(getResources().getString(R.string.amritsar_attraction_name_2));
        amritsar_jal_bagh.setLatitude(22.56167);
        amritsar_jal_bagh.setLongitude(120.30700);
        attractions.add(new Attraction(getResources().getString(R.string.amritsar_attraction_name_2),
                getResources().getString(R.string.amritsar_attraction_phone_2), getResources().getString(R.string.amritsar_attraction_address_2),
                getResources().getString(R.string.amritsar_attraction_imageurl_2), amritsar_jal_bagh));

        Location durgiana_mandir = new Location(getResources().getString(R.string.amritsar_attraction_name_3));
        durgiana_mandir.setLatitude(22.680453);
        durgiana_mandir.setLongitude(120.2902775);
        attractions.add(new Attraction(getResources().getString(R.string.amritsar_attraction_name_3),
                getResources().getString(R.string.amritsar_attraction_phone_3), getResources().getString(R.string.amritsar_attraction_address_3),
                getResources().getString(R.string.amritsar_attraction_imageurl_3), durgiana_mandir));

        Location wagah_border = new Location(getResources().getString(R.string.amritsar_attraction_name_4));
        wagah_border.setLatitude(22.6313909);
        wagah_border.setLongitude(120.2997623);
        attractions.add(new Attraction(getResources().getString(R.string.amritsar_attraction_name_4),
                getResources().getString(R.string.amritsar_attraction_phone_4), getResources().getString(R.string.amritsar_attraction_address_4),
                getResources().getString(R.string.amritsar_attraction_imageurl_4), wagah_border));

        Location ranjitSingh_museum = new Location(getResources().getString(R.string.amritsar_attraction_name_5));
        ranjitSingh_museum.setLatitude(22.6315391);
        ranjitSingh_museum.setLongitude(120.2319094);
        attractions.add(new Attraction(getResources().getString(R.string.amritsar_attraction_name_5),
                getResources().getString(R.string.amritsar_attraction_phone_5), getResources().getString(R.string.amritsar_attraction_address_5),
                getResources().getString(R.string.amritsar_attraction_imageurl_5), ranjitSingh_museum));

        AttractionAdapter adapter = new AttractionAdapter(this, attractions);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = attractions.get(position).getLocation().getLatitude();
                Log.d("lat", ""+lat);
                double lon = attractions.get(position).getLocation().getLongitude();
                Log.d("lon", ""+lon);
                String keyword = attractions.get(position).getAttractionName();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(keyword));

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
    }
}
