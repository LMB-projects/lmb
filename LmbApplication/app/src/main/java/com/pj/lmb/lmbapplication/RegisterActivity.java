package com.pj.lmb.lmbapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

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

        mTitleEdit = (EditText) findViewById(R.id.name);
        mDataEdit = (EditText) findViewById(R.id.date);
        mTimeEdit = (EditText) findViewById(R.id.time);
        mMultilineEdit = (EditText) findViewById(R.id.contents);
        mSpinnerEdit = (Spinner) findViewById(R.id.category);
    }

   public void onRegisterBtnClick(View view){
       //DBに登録
       RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
       Realm realm = Realm.getInstance(realmConfiguration);

       Number maxId = realm.where(Schedule.class).max("id");
       int nextId = 1;
       if(maxId == null) {
           nextId = maxId.intValue() + 1;
       } else {
            
       }


       Schedule scheduleData = realm.createObject(Schedule.class);

       //IDのセット

       scheduleData.setId(nextId);

       //データのセット
       scheduleData.setTitle(mTitleEdit.getText().toString());
       scheduleData.setDate(mDataEdit.getText().toString());
       scheduleData.setTime(mTimeEdit.getText().toString());
       scheduleData.setContents(mMultilineEdit.getText().toString());
       scheduleData.setCategoryNumber(mSpinnerEdit.getSelectedItemPosition());

        // 確認ダイアログの作成
       AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
       alertDlg.setTitle("スケジュールの登録");
       alertDlg.setMessage("登録しました。");
       alertDlg.setPositiveButton(
               "OK",
               new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int which) {
                       // OK ボタンクリック処理
                   }
               });

       // 表示
       alertDlg.create().show();

       realm.beginTransaction();
    }
}
