package com.pj.lmb.lmbapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }

    public void onPlanBtnTapped(View v){
        Intent intent = new Intent(CalendarActivity.this,ListActivity.class);
        startActivity(intent);
    }
}
