package com.example.android.hellosharedprefs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.example.android.hellosharedprefs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //maintaining count
    private int mCount = 0;
    //maintaining color
    private int mColor;
    ActivityMainBinding b;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

       //initializing shared preference
       SharedPreferences preferences = getPreferences(MODE_PRIVATE);
       mCount = preferences.getInt(Constants.COUNT,0);
       mColor = preferences.getInt(Constants.COLOR,R.color.colorPrimary);

       //setting restored text to counter
       b.counter.setText(""+mCount);
       //setting restored background colour to counter
       b.counter.setBackgroundColor(mColor);
    }

    @Override
    protected void onPause() {
        super.onPause();

        //storing information on pause
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        preferences.edit().putInt(Constants.COUNT, mCount).apply();
        preferences.edit().putInt(Constants.COLOR,mColor).apply();
    }

    //changing color to black
    public void changeColourToBlack(View view) {
        mColor = getResources().getColor(R.color.black);
        //setting color
        b.counter.setBackgroundColor(mColor);
    }

    //changing color to red
    public void changeColourToRed(View view) {
        mColor = getResources().getColor(R.color.red);
        b.counter.setBackgroundColor(mColor);
    }

    //changing color to blue
    public void changeColourToBlue(View view) {
        mColor = getResources().getColor(R.color.blue);
        b.counter.setBackgroundColor(mColor);
    }

    //changing color to green
    public void changeColourToGreen(View view) {
        mColor = getResources().getColor(R.color.green);
        b.counter.setBackgroundColor(mColor);
    }

    //incrementing count
    public void incCount(View view) {
        mCount++;
        //setting count
        b.counter.setText(""+mCount);
    }

    //reset default color and count
    public void resetColor(View view) {
        mCount = 0;
        b.counter.setText(""+mCount);

        mColor = ContextCompat.getColor(this,
                R.color.default_color);

        b.counter.setBackgroundColor(mColor);
    }


}