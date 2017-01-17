package com.pj.lmb.lmbapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

   public void onRegisterBtnClick(View view){
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
    }
}
