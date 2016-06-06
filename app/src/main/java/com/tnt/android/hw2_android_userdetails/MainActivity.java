package com.tnt.android.hw2_android_userdetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.edit_name);
        btnEnter = (Button) findViewById(R.id.btn_enter);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString().trim();

                if(!containsOnlyLetters(name)){
                    editName.setError("Incorrect name! Use only letters and space");
                }else{
                    Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            }
        });
    }

    public boolean containsOnlyLetters(String name){

        char[] simbols = name.toCharArray();

        if(simbols.length > 1){
            for(char ch : simbols){
                if(ch != 32 && (ch < 65 || ch > 122)){
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}
