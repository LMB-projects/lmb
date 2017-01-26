package com.pj.lmb.lmbapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import io.realm.Realm;
import io.realm.RealmResults;

public class DetailsActivity extends AppCompatActivity {

    EditText mTitleEdit;
    EditText mDateEdit;
    EditText mTimeEdit;
    EditText mMultilineEdit;
    Spinner mSpinnerEdit;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Initialize Realm
        Realm.init(this);
        //realmのインスタンスを生成
        Realm realm = Realm.getDefaultInstance();

        mTitleEdit = (EditText) findViewById(R.id.title);
        mDateEdit = (EditText) findViewById(R.id.date);
        mTimeEdit = (EditText) findViewById(R.id.time);
        mMultilineEdit = (EditText) findViewById(R.id.contents);
        mSpinnerEdit = (Spinner) findViewById(R.id.category);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // アイテムを追加します
        adapter.add("LOVE");
        adapter.add("EVENT");
        adapter.add("WORK");

        //一覧画面を取得
        Intent intent = getIntent();
        id = intent.getIntExtra("ID",1);

        RealmResults<Schedule> result = realm.where(Schedule.class).equalTo("id", id).findAll();

        mTitleEdit.setText(result.get(0).getTitle());
        mDateEdit.setText(result.get(0).getDate());
        mTimeEdit.setText(result.get(0).getTime());
        mMultilineEdit.setText(result.get(0).getContents());
        mSpinnerEdit.setAdapter(adapter);
        mSpinnerEdit.setSelection(result.get(0).getCategoryNumber());

    }


    public void onDeleteClickButton(final View view) {

        //realmのインスタンスを生成
        final Realm realm = Realm.getDefaultInstance();

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
                        realm.where(Schedule.class).equalTo("id", id).findFirst().deleteFromRealm();

                        //コミット
                        realm.commitTransaction();

                        alertDlg.setMessage("予定を削除しました");

                        // 一覧に戻る
                        Intent intent = new Intent(DetailsActivity.this, ListActivity.class);
                        startActivity(intent);
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
