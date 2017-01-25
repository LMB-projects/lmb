package com.pj.lmb.lmbapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list.add("買い物");
        list.add("ジム");
        list.add("デート");

        listView = (ListView) findViewById(R.id.listView);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();

        Realm realm = Realm.getInstance(realmConfiguration);
        RealmResults<Schedule> results = realm.where(Schedule.class).findAll();

        // for文でresultsの結果を件数分listに入れる



        // ArrayAdapterオブジェクトの生成
        // simple_list_item_1は、もともと用意されているレイアウトファイルのID
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);

        // Adapterの指定
        listView.setAdapter(arrayAdapter);
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
