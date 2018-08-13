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

public class PatialaActivity extends AppCompatActivity {
    private ArrayList<Attraction> attractions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_list);

        // Create a list of attractions
        attractions = new ArrayList<Attraction>();
        Location gurudwara_dukhNivaran = new Location(getResources().getString(R.string.patiala_attraction_name_1));
        gurudwara_dukhNivaran.setLatitude(25.0262737);
        gurudwara_dukhNivaran.setLongitude(121.5694812);
        attractions.add(new Attraction(getResources().getString(R.string.patiala_attraction_name_1), getResources().getString(R.string.patiala_attraction_phone_1), getResources().getString(R.string.patiala_attraction_address_1), getResources().getString(R.string.patiala_attraction_imageurl_1), gurudwara_dukhNivaran));

        Location kali_mataMandir = new Location(getResources().getString(R.string.patiala_attraction_name_2));
        kali_mataMandir.setLatitude(25.03699);
        kali_mataMandir.setLongitude(121.49993);
        attractions.add(new Attraction(getResources().getString(R.string.patiala_attraction_name_2), getResources().getString(R.string.patiala_attraction_phone_2), getResources().getString(R.string.patiala_attraction_address_2), getResources().getString(R.string.patiala_attraction_imageurl_2), kali_mataMandir));

        Location sheesh_mahal = new Location(getResources().getString(R.string.patiala_attraction_name_3));
        sheesh_mahal.setLatitude(24.96894);
        sheesh_mahal.setLongitude(121.58825);
        attractions.add(new Attraction(getResources().getString(R.string.patiala_attraction_name_3), getResources().getString(R.string.patiala_attraction_phone_3), getResources().getString(R.string.patiala_attraction_address_3), getResources().getString(R.string.patiala_attraction_imageurl_3), sheesh_mahal));

        Location baradari_garden = new Location(getResources().getString(R.string.patiala_attraction_name_4));
        baradari_garden.setLatitude(25.03568);
        baradari_garden.setLongitude(121.51967);
        attractions.add(new Attraction(getResources().getString(R.string.patiala_attraction_name_4), getResources().getString(R.string.patiala_attraction_phone_4), getResources().getString(R.string.patiala_attraction_address_4), getResources().getString(R.string.patiala_attraction_imageurl_4), baradari_garden));

        Location dhillon = new Location(getResources().getString(R.string.patiala_attraction_name_5));
        dhillon.setLatitude(25.10236);
        dhillon.setLongitude(121.54849);
        attractions.add(new Attraction(getResources().getString(R.string.patiala_attraction_name_5),
                getResources().getString(R.string.patiala_attraction_phone_5), getResources().getString(R.string.patiala_attraction_address_5),
                getResources().getString(R.string.patiala_attraction_imageurl_5), dhillon));

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
