package com.tnt.android.hw2_android_userdetails;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by USER on 5.6.2016 г..
 */
public class SummaryActivity extends AppCompatActivity{

    TextView txtUserInfo;
    Button btnMap;

    String city;
    String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        String name = getIntent().getStringExtra("name");
        int age = getIntent().getIntExtra("age", 0);
        address = getIntent().getStringExtra("address");
        city = getIntent().getStringExtra("city");

        txtUserInfo = (TextView) findViewById(R.id.txt_user_info);
        txtUserInfo.setText(generateUserInfo(name, age, address, city));

        btnMap = (Button) findViewById(R.id.btn_map);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + city + "+" + address);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

    }

    private String generateUserInfo(String name, int age, String address, String city){
        return name + ", " + age + "\n" + address + ",\nгр. " + city;
    }
}
