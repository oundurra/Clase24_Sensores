package com.example.clase24_sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    Sensor sensor;
    EditText editTextX;
    EditText editTextY;
    EditText editTextZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        editTextX = (EditText) findViewById(R.id.txtX);
        editTextY = (EditText) findViewById(R.id.txtY);
        editTextZ = (EditText) findViewById(R.id.txtZ);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        editTextX.setText(Float.toString(event.values[0]));
        editTextY.setText(Float.toString(event.values[1]));
        editTextZ.setText(Float.toString(event.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}