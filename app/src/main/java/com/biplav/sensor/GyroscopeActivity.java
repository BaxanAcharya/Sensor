package com.biplav.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GyroscopeActivity extends AppCompatActivity {

    EditText etone,ettwo;
    TextView tvres;
    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        etone=findViewById(R.id.etone);
        ettwo=findViewById(R.id.ettwo);
        tvres=findViewById(R.id.tvresult);
        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        SensorEventListener sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                int one= Integer.parseInt(etone.getText().toString());
                int two= Integer.parseInt(ettwo.getText().toString());
                    int add=one+two;
                    int sub=one-two;
                if (event.values[1]<0){
                    tvres.setText(""+add);
                }else if (event.values[1]>0){
                    tvres.setText(""+sub);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        if (sensor!=null){
            sensorManager.registerListener(sensorEventListener,sensor,sensorManager.SENSOR_DELAY_NORMAL);
        }else {
            Toast.makeText(this, "Sensor not found", Toast.LENGTH_SHORT).show();
        }

    }
}
