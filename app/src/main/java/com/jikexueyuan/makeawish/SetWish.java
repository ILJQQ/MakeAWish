package com.jikexueyuan.makeawish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SetWish extends AppCompatActivity {

//    申明事件
    public EditText etWishInput;
    private Button confirm, cancel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_wish);

//      为按键添加事件监听器
        etWishInput = (EditText) findViewById(R.id.etWishInput);
        confirm = (Button) findViewById(R.id.btnConfirm);
        cancel = (Button) findViewById(R.id.btnCancel);

//      当取消键被点击时判定为取消状态并跳转回源界面
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                SetWish.this.setResult(RESULT_CANCELED,i);
                SetWish.this.finish();
            }
        });

//      当确定键被点击时判断输入框内容并在输入框有内容时进行保存并跳转
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etWishInput.length() == 0){
                    Toast.makeText(SetWish.this,"请先写下您的愿望", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent();
                    i.putExtra("wrappedData",etWishInput.getText().toString());
                    SetWish.this.setResult(RESULT_OK,i);
                    SetWish.this.finish();
                }
            }
        });
    }
}
