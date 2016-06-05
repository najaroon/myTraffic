package com.najaroon.nong.mytraffic3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private ListView trafficListView;
    private Button aboutMeButton;
    private String urlYoutubeString = "https://youtu.be/xuAyqEn-0sc";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind Widget
        trafficListView = (ListView) findViewById(R.id.listView);
        aboutMeButton = (Button) findViewById(R.id.button);

        // Controller Button
        controllerButton();

        // Controller ListView
        controllerListView();


    }   // Main Method

    private void controllerListView() {

        // SetUp for Name
        final String[] nameStrings = new String[20];
        nameStrings[0] = "หัวข้อหลักที่ 1";
        nameStrings[1] = "หัวข้อหลักที่ 2";
        nameStrings[2] = "หัวข้อหลักที่ 3";
        nameStrings[3] = "หัวข้อหลักที่ 4";
        nameStrings[4] = "หัวข้อหลักที่ 5";
        nameStrings[5] = "หัวข้อหลักที่ 6";
        nameStrings[6] = "หัวข้อหลักที่ 7";
        nameStrings[7] = "หัวข้อหลักที่ 8";
        nameStrings[8] = "หัวข้อหลักที่ 9";
        nameStrings[9] = "หัวข้อหลักที่ 10";
        nameStrings[10] = "หัวข้อหลักที่ 11";
        nameStrings[11] = "หัวข้อหลักที่ 12";
        nameStrings[12] = "หัวข้อหลักที่ 13";
        nameStrings[13] = "หัวข้อหลักที่ 14";
        nameStrings[14] = "หัวข้อหลักที่ 15";
        nameStrings[15] = "หัวข้อหลักที่ 16";
        nameStrings[16] = "หัวข้อหลักที่ 17";
        nameStrings[17] = "หัวข้อหลักที่ 18";
        nameStrings[18] = "หัวข้อหลักที่ 19";
        nameStrings[19] = "หัวข้อหลักที่ 20";

        // For Detail Short
        String[] detailStrings = getResources().getStringArray(R.array.detail_short);

        //For Image
        MyData myData = new MyData();
        final int[] ints = myData.getInts();

        //Create ListView
        MyAdapter myAdapter = new MyAdapter(this, ints, nameStrings, detailStrings);
        trafficListView.setAdapter(myAdapter);

        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("Name", nameStrings[position]);
                intent.putExtra("Image", ints[position]);
                intent.putExtra("Index", position);
                startActivity(intent);


            }// onItemClick
        });



    }   // ControllerListView

    private void controllerButton() {

        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Sound Effect
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.effect_btn_long);
                mediaPlayer.start();

                // Web View
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlYoutubeString));
                startActivity(intent);

            } // onClick
        });

    }// ControllerButton


}   //Main Class
