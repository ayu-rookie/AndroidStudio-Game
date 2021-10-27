package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

public class EndCode extends AppCompatActivity{

    private TextView textView_genie;
    private TextView textView_name;
    private Button button_me;
    int dialogue = 1,code=0;
    String name = "", end="";

    private EditText edtATM;
    private Button btnN1, btnN2, btnN3;
    private Button btnN4, btnN5, btnN6;
    private Button btnN7, btnN8, btnN9, btnN0;
    private Button btnBack, btnEnd;
    private TableLayout TableLayout_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        name = bundle.getString("NAME");
        end = bundle.getString("END");


        button_me = (Button) findViewById(R.id.button_me);
        textView_genie = (TextView) findViewById(R.id.textView_genie);
        textView_name = (TextView) findViewById(R.id.textView_name);
        button_me.setOnClickListener(button_meListener);

        TableLayout_code=(TableLayout)findViewById(R.id.TableLayout_code);
        edtATM=(EditText)findViewById(R.id.edtATM);
        btnN1=(Button)findViewById(R.id.btnN1);
        btnN2=(Button)findViewById(R.id.btnN2);
        btnN3=(Button)findViewById(R.id.btnN3);
        btnN4=(Button)findViewById(R.id.btnN4);
        btnN5=(Button)findViewById(R.id.btnN5);
        btnN6=(Button)findViewById(R.id.btnN6);
        btnN7=(Button)findViewById(R.id.btnN7);
        btnN8=(Button)findViewById(R.id.btnN8);
        btnN9=(Button)findViewById(R.id.btnN9);
        btnN0=(Button)findViewById(R.id.btnN0);
        btnBack=(Button)findViewById(R.id.btnBack);
        btnEnd=(Button)findViewById(R.id.btnEnd);

        //設定共用事件
        btnN1.setOnClickListener(listener);
        btnN2.setOnClickListener(listener);
        btnN3.setOnClickListener(listener);
        btnN4.setOnClickListener(listener);
        btnN5.setOnClickListener(listener);
        btnN6.setOnClickListener(listener);
        btnN7.setOnClickListener(listener);
        btnN8.setOnClickListener(listener);
        btnN9.setOnClickListener(listener);
        btnN0.setOnClickListener(listener);
        btnBack.setOnClickListener(listener);
        btnEnd.setOnClickListener(listener);

        textView_name.setText(name);
    }

    private Button.OnClickListener button_meListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (dialogue == 1) {
                TableLayout_code.setVisibility(View.VISIBLE);
                textView_genie.setText("| 把魔碼輸入至陣內...");
                button_me.setText("輸入 ");

                dialogue++;
            }
            else if(dialogue==2){
                code = Integer.parseInt(edtATM.getText().toString());
                dialogue++;
                if(code==777){
                    Intent intent_door=new Intent();
                    intent_door.setClass(EndCode.this,GoodEnd.class);

                    Bundle bundle=new Bundle();
                    bundle.putString("NAME",name);
                    bundle.putString("END",end);
                    intent_door.putExtras(bundle);
                    startActivity(intent_door);
                }
               else if(code==666){
                    Intent intent_door=new Intent();
                    intent_door.setClass(EndCode.this,BadEnd.class);

                    Bundle bundle=new Bundle();
                    bundle.putString("NAME",name);
                    bundle.putString("END",end);
                    intent_door.putExtras(bundle);
                    startActivity(intent_door);
                }

            }



        }
    };

    private Button.OnClickListener listener=new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btnN1:  //按 1 鈕
                    displayATM("1");
                    break;
                case R.id.btnN2:  //按 2 鈕
                    displayATM("2");
                    break;
                case R.id.btnN3:  //按 3 鈕
                    displayATM("3");
                    break;
                case R.id.btnN4:  //按 4 鈕
                    displayATM("4");
                    break;
                case R.id.btnN5:  //按 5 鈕
                    displayATM("5");
                    break;
                case R.id.btnN6:  //按 6 鈕
                    displayATM("6");
                    break;
                case R.id.btnN7:  //按 7 鈕
                    displayATM("7");
                    break;
                case R.id.btnN8:  //按 8 鈕
                    displayATM("8");
                    break;
                case R.id.btnN9:  //按 9 鈕
                    displayATM("9");
                    break;
                case R.id.btnN0:  //按 0 鈕
                    displayATM("0");
                    break;
                case R.id.btnBack:  //按 清除 鈕
                    String str=edtATM.getText().toString();
                    if(str.length()>0) {
                        str=str.substring(0, str.length()-1);
                        edtATM.setText(str);
                    }
                    break;

            }
        }
    };

    private void displayATM(String s) {
        String str=edtATM.getText().toString();
        edtATM.setText(str + s);
    }
}
