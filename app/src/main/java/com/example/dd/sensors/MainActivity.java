package com.example.dd.sensors;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private static final String TAG="MainActivity";
    TextView tv1=null;
    private SensorManager mSensorManager;
    Sensor acceleromter;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: initialising sensor services");

        tv1 = (TextView) findViewById(R.id.textView2);
        tv1.setVisibility(View.GONE);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        acceleromter=mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(MainActivity.this, acceleromter, SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: registered accelerometer");
        List<Sensor> mList= mSensorManager.getSensorList(Sensor.TYPE_ALL);

        for (int i = 1; i < mList.size(); i++) {
            tv1.setVisibility(View.VISIBLE);
            tv1.append("\n" + mList.get(i).getName() + "\n" + mList.get(i).getVendor() + "\n" + mList.get(i).getVersion());
        }
    }
    public void sensorList(View view){
        Button mybtn= (Button) findViewById(R.id.sensorlist);

        mybtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent myintent = new Intent(getBaseContext(), MainActivity.class);

                startActivity(myintent);
            }
        } );
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d(TAG, "onSensorChanged: X: " +event.values[0] +" Y " +event.values[1] +"Z" +event.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {


    }
}