package com.biplav.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class DashboradActivity extends AppCompatActivity {


    Button btna,btnl,btng,btnp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashborad);

        btna=findViewById(R.id.btna);
        btnl=findViewById(R.id.btnl);
        btng=findViewById(R.id.btng);
        btnp=findViewById(R.id.btnp);
        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),AccelerometerActivity.class);
                startActivity(intent);
            }
        });

        btnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        btng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),GyroscopeActivity.class);
                startActivity(intent);
            }
        });

        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), ProximityActivity.class);
                startActivity(intent);
            }
        });
    }
}
