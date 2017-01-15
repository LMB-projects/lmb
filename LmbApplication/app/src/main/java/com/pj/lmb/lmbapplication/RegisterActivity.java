package com.pj.lmb.lmbapplication;

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
        Button register = (Button)findViewById(R.id.register_button);
        register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String message = "登録しました。";
                Toast toast = Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }

//   public void onRegisterBtnClick(Button button){
//        Intent intent = new Intent(RegisterActivity.this){

//        }
//    }
}
