package com.pj.lmb.lmbapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    public void onRegisterBtnTapped(View v){
        Intent intent = new Intent(ListActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

    public void onDetailsBtnTapped(View v){
        Intent intent = new Intent(ListActivity.this,DetailsActivity.class);
        startActivity(intent);
    }
}
