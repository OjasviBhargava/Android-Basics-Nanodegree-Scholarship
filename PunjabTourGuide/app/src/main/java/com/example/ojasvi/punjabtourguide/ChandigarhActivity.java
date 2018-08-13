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

public class ChandigarhActivity extends AppCompatActivity {
    private ArrayList<Attraction> attractions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_list);

        // Create a list of attractions
        attractions = new ArrayList<Attraction>();
        Location rock_garden = new Location(getResources().getString(R.string.chandigarh_attraction_name_1));
        rock_garden.setLatitude(22.93648);
        rock_garden.setLongitude(120.22779);
        attractions.add(new Attraction(getResources().getString(R.string.chandigarh_attraction_name_1),
                getResources().getString(R.string.chandigarh_attraction_phone_1), getResources().getString(R.string.chandigarh_attraction_address_1),
                getResources().getString(R.string.chandigarh_attraction_imageurl_1), rock_garden));

        Location rose_garden = new Location(getResources().getString(R.string.chandigarh_attraction_name_2));
        rose_garden.setLatitude(23.00341);
        rose_garden.setLongitude(120.15949);
        attractions.add(new Attraction(getResources().getString(R.string.chandigarh_attraction_name_2),
                getResources().getString(R.string.chandigarh_attraction_phone_2), getResources().getString(R.string.chandigarh_attraction_address_2),
                getResources().getString(R.string.chandigarh_attraction_imageurl_2), rose_garden));

        Location sukhna_lake = new Location(getResources().getString(R.string.chandigarh_attraction_name_3));
        sukhna_lake.setLatitude(22.99879);
        sukhna_lake.setLongitude(120.20269);
        attractions.add(new Attraction(getResources().getString(R.string.chandigarh_attraction_name_3),
                getResources().getString(R.string.chandigarh_attraction_phone_3), getResources().getString(R.string.chandigarh_attraction_address_3),
                getResources().getString(R.string.chandigarh_attraction_imageurl_3), sukhna_lake));

        Location chhatbir_zoo = new Location(getResources().getString(R.string.chandigarh_attraction_name_4));
        chhatbir_zoo.setLatitude(22.93861);
        chhatbir_zoo.setLongitude(120.22908);
        attractions.add(new Attraction(getResources().getString(R.string.chandigarh_attraction_name_4),
                getResources().getString(R.string.chandigarh_attraction_phone_4), getResources().getString(R.string.chandigarh_attraction_address_4),
                getResources().getString(R.string.chandigarh_attraction_imageurl_4), chhatbir_zoo));

        Location elante_mall = new Location(getResources().getString(R.string.chandigarh_attraction_name_5));
        elante_mall.setLatitude(22.99311);
        elante_mall.setLongitude(120.20496);
        attractions.add(new Attraction(getResources().getString(R.string.chandigarh_attraction_name_5),
                getResources().getString(R.string.chandigarh_attraction_phone_5), getResources().getString(R.string.chandigarh_attraction_address_5),
                getResources().getString(R.string.chandigarh_attraction_imageurl_5), elante_mall));

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