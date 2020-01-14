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

public class ProximityActivity extends AppCompatActivity {

    EditText etonep,ettwop;
    TextView tvresp;
    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);
        etonep=findViewById(R.id.etonep);
        ettwop=findViewById(R.id.ettwop);
        tvresp=findViewById(R.id.tvresultp);
        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        SensorEventListener sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                int one= Integer.parseInt(etonep.getText().toString());
                int two= Integer.parseInt(ettwop.getText().toString());
                int add=one+two;
                if (event.values[0]<=4)
                {
                    tvresp.setText("The sum is "+ add);
                }else {
                    tvresp.setText("You are far");
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
