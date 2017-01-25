package com.pj.lmb.lmbapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class DetailsActivity extends AppCompatActivity {

    EditText mTitleEdit;
    EditText mDateEdit;
    EditText mTimeEdit;
    EditText mMultilineEdit;
    Spinner mSpinnerEdit;

    //RealmConfigurationのクラスを作成
    RealmConfiguration realmConfig = new RealmConfiguration.Builder().build();
    //realmのインスタンスを生成
    Realm realm = Realm.getInstance(realmConfig);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        mTitleEdit = (EditText) findViewById(R.id.title);
        mDateEdit = (EditText) findViewById(R.id.date);
        mTimeEdit = (EditText) findViewById(R.id.time);
        mMultilineEdit = (EditText) findViewById(R.id.contents);
        mSpinnerEdit = (Spinner) findViewById(R.id.category);

        //一覧画面を取得
        Intent intent = getIntent();
        int id = intent.getIntExtra("ID",1);

        RealmResults<Schedule> result = realm.where(Schedule.class).equalTo("id", id).findAll();

        mTitleEdit.setText(result.get(0).getTitle());
        mDateEdit.setText(result.get(0).getTitle());
        mTimeEdit.setText(result.get(0).getTitle());
        mMultilineEdit.setText(result.get(0).getTitle());
        //mSpinnerEdit.setOnClickListener(result.get(0).getCategoryNumber());

    }


    public void onDeleteClickButton(View view) {

        // 確認ダイアログの生成
        final AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
        alertDlg.setTitle("予定を削除します");
        alertDlg.setMessage("よろしいですか？");
        alertDlg.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {



                        //トランザクション開始
                        realm.beginTransaction();

                        //リスト画面から取得したidの情報を取得し、削除
                        realm.where(Schedule.class).equalTo("id", "1").findFirst().deleteFromRealm();

                        //コミット
                        realm.commitTransaction();

                        alertDlg.setMessage("予定を削除しました");
                    }
                });
        alertDlg.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Cancel ボタンクリック処理
                    }
                });

        // 表示
        alertDlg.create().show();

    }
}
