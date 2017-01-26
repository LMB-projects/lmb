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

public class RegisterActivity extends AppCompatActivity {

    EditText mTitleEdit;
    EditText mDataEdit;
    EditText mTimeEdit;
    EditText mMultilineEdit;
    Spinner mSpinnerEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // アイテムを追加します
        adapter.add("LOVE");
        adapter.add("EVENT");
        adapter.add("WORK");
        mTitleEdit = (EditText) findViewById(R.id.name);
        mDataEdit = (EditText) findViewById(R.id.date);
        mTimeEdit = (EditText) findViewById(R.id.time);
        mMultilineEdit = (EditText) findViewById(R.id.contents);
        mSpinnerEdit = (Spinner) findViewById(R.id.category);
        mSpinnerEdit.setAdapter(adapter);
    }

   public void onRegisterBtnClick(View view){

       // Realm開始
       Realm.init(this);

        // 確認ダイアログの作成
       AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
       alertDlg.setTitle("スケジュールの登録");
       alertDlg.setMessage("登録しました。");
       alertDlg.setPositiveButton(
               "OK",
               new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int which) {
                       // OK ボタンクリック処理
                       // DBに登録

                       // realmのインスタンスを生成
                       Realm realm = Realm.getDefaultInstance();

                       // トランザクション開始
                       realm.beginTransaction();

                       // IDの生成
                       Number maxId = realm.where(Schedule.class).max("id");
                       int nextId = 1;
                       if(maxId != null) {
                           nextId = maxId.intValue() + 1;
                       }

                       // 更新用RealmObject作成
                       Schedule scheduleData = realm.createObject(Schedule.class);

                       // IDのセット
                       scheduleData.setId(nextId);

                       //データのセット
                       scheduleData.setTitle(mTitleEdit.getText().toString());
                       scheduleData.setDate(mDataEdit.getText().toString());
                       scheduleData.setTime(mTimeEdit.getText().toString());
                       scheduleData.setContents(mMultilineEdit.getText().toString());
                       scheduleData.setCategoryNumber(mSpinnerEdit.getSelectedItemPosition());

                       // トランザクション終了
                       realm.commitTransaction();

                       // 一覧に戻る
                       Intent intent = new Intent(RegisterActivity.this, ListActivity.class);
                       startActivity(intent);
                   }
               });

       // 表示
       alertDlg.create().show();




    }
}
