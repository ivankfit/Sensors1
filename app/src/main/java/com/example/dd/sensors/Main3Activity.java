package com.example.dd.sensors;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        sensor();
        motion();
    }


    private void sensor() {

        Button mybtn= (Button) findViewById(R.id.sensors);

        mybtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent myintent = new Intent(Main3Activity.this,MainActivity.class);

                startActivity(myintent);
            }
        } );
    }

    private void motion() {
        Button mybtn= (Button) findViewById(R.id.motion);

        mybtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent myintent = new Intent(Main3Activity.this,Main2Activity.class);

                startActivity(myintent);
            }
        } );
    }

}
