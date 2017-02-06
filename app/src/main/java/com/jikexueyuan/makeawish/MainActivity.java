package com.jikexueyuan.makeawish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    申明事件
    private Button btnMakeWish;
    private TextView tvGetWish;
    private TextView tvIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      添加监听事件
        btnMakeWish =(Button)findViewById(R.id.btnMakeWish);
        tvGetWish = (TextView) findViewById(R.id.tvGetWish);

//      打开新的activity
        btnMakeWish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this, SetWish.class);
                startActivityForResult(i,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//      实验代码用于查找判断错误位置
        System.out.println("成功检测到返回值");

//        监听来自事件一的回馈
        if (requestCode == 1){

//            当返回状态为cancel时判断为用户取消输入
            if(resultCode == SetWish.RESULT_CANCELED){
                Toast.makeText(MainActivity.this, "您取消了输入", Toast.LENGTH_SHORT).show();
            }

//            当返回状态为ok时按设定格式显示事件返回值
            if (resultCode == SetWish.RESULT_OK){
                tvIntro = (TextView) findViewById(R.id.tvIntro);
                String resultData = data.getStringExtra("wrappedData");
//                显示部分
                tvIntro.setVisibility(View.VISIBLE);
                tvGetWish.setText("\u3000\u3000" + resultData);
            }
        }
    }
}
