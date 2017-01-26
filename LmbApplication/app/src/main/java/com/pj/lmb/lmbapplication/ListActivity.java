package com.pj.lmb.lmbapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    List<Schedule> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        listView = (ListView) findViewById(R.id.listView);

        // Realm開始
        Realm.init(this);

        /// realmのインスタンスを生成
        Realm realm = Realm.getDefaultInstance();

        // 一覧用結果を取得
        RealmResults<Schedule> results = realm.where(Schedule.class).findAll();

        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(this,results);

        // Adapterの指定
        listView.setAdapter(scheduleAdapter);

        // Adapterのイベント
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 選択されたitemのindex取得
                Schedule schedule = (Schedule) parent.getItemAtPosition(position);
                // 選択されたiindexのidを詳細画面へ引き渡し
                startActivity(new Intent(ListActivity.this, DetailsActivity.class)
                        .putExtra("ID", schedule.getId()));
            }
        });
    }

    public void onRegisterBtnTapped(View v){
        Intent intent = new Intent(ListActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
