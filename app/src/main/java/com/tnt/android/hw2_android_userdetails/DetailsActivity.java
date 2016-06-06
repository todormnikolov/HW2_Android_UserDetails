package com.tnt.android.hw2_android_userdetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    EditText editAge;
    EditText editAddress;
    EditText editCity;
    EditText editBornData;
    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        editAge = (EditText) findViewById(R.id.edit_age);
        editAddress = (EditText) findViewById(R.id.edit_address);
        editCity = (EditText) findViewById(R.id.edit_city);
        editBornData = (EditText) findViewById(R.id.edit_born_data);
        btnContinue = (Button) findViewById(R.id.btn_continue);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int age = -1;

                try {
                    age = Integer.parseInt(editAge.getText().toString());

                    if(age < 1 || age > 130){
                        printToast("Годините не са коректни!");
                        return;
                    }
                }catch(NumberFormatException ex){
                    printToast("Годините са неправилни");
                }

                String address = editAddress.getText().toString();
                String city = editCity.getText().toString();
                String bornDate = editBornData.getText().toString();

                if(address.length() <= 5 || address.length() > 100){
                    printToast("Адреса не е правилен!");
                    return;
                }

                if(city.length() < 2 || city.length() > 50){
                    printToast("Неправилна информация за град!");
                    return;
                }

                if(bornDate.length() < 8 || bornDate.length() > 10){
                    printToast("Датата на раждане е грешна!");
                    return;
                }

                String name = getIntent().getStringExtra("name");

                Intent intent = new Intent(DetailsActivity.this, SummaryActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("age", age);
                intent.putExtra("address", address);
                intent.putExtra("city", city);
                intent.putExtra("bornDate", bornDate);
                startActivity(intent);

            }
        });

    }

    private void printToast(String message){

        //CharSequence text = "Information in field " + field + " isn't correct!";

        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.show();
    }

}
