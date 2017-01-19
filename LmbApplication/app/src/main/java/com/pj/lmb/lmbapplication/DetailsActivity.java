package com.pj.lmb.lmbapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mTitleEdit = (EditText) findViewById(R.id.title);
        mDateEdit = (EditText) findViewById(R.id.date);
        mTimeEdit = (EditText) findViewById(R.id.time);
        mMultilineEdit = (EditText) findViewById(R.id.contents);
        mSpinnerEdit = (Spinner) findViewById(R.id.category);


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

                        //RealmConfigurationのクラスを作成
                        RealmConfiguration realmConfig = new RealmConfiguration.Builder().build();
                        //realmのインスタンスを生成
                        Realm realm = Realm.getInstance(realmConfig);

                        //トランザクション開始
                        realm.beginTransaction();

                        //リスト画面から取得したidの情報を取得
                        RealmResults<Schedule> result = realm.where(Schedule.class).equalTo("id", "1").findAll();

                        //情報を削除
                        result.remove(0);

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
