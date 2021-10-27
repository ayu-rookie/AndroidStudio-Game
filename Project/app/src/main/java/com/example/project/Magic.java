package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Magic extends AppCompatActivity{

    private TextView textView_genie;
    private TextView textView_name;
    private Button button_me;
    int dialogue = 1;
    String name = "",end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magicpage);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        name = bundle.getString("NAME");
        end=bundle.getString("END");

        button_me = (Button) findViewById(R.id.button_me);
        textView_genie = (TextView) findViewById(R.id.textView_genie);
        textView_name = (TextView) findViewById(R.id.textView_name);
        button_me.setOnClickListener(button_meListener);

        textView_name.setText(name);
    }

    private Button.OnClickListener button_meListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (dialogue == 1) {
                textView_genie.setText("\n"+"津:"+"\n" +"\n" +"「"+name + "大人，您怎麼了 ! 」" + "\n" + "\n" + "\n" + "\n" +  " | 有一股熟悉的魔力氣息..."
                        +"\n" + "\n" + " | 是之前的那個魔法嗎...?");
                button_me.setText("不 !");
                dialogue++;
            }
            else if (dialogue == 2) {
                textView_genie.setText("\n"+"津:"+"\n" +"\n" +"「大人?」" + "\n" + "\n" + "\n" +
                        " | 不對，" + "\n" + "\n" +" | 因為這次的魔力雖然細微，"+"\n" +" | 但還是查覺到了。" +"\n"+"\n"+ "\n" +" | 這次的是稍弱一些的魔法才對。");
                button_me.setText("就是你在呼喚我吧 !");
                dialogue++;
            }
            else if (dialogue == 3) {
                textView_genie.setText("津:"+"\n" +"\n" +"「大人，您再說些什麼...?」" + "\n" + "\n" + "\n" +
                         " | 雖然搞不太清楚，"+"\n" +" | 但有件事情可以確定。"+"\n" +"\n" +" | 那就是這兩股魔力，"+"\n" +"\n" +" | 都屬於*同一個人。"+ "\n" + "\n" +"\n" +" | 必須抓緊腳步才行了。");
                button_me.setText("津，抓住我 !");
                dialogue++;


            }

            else if (dialogue == 4) {
                Intent intent_magic2=new Intent();
                intent_magic2.setClass(Magic.this,Magic2.class);

                Bundle bundle=new Bundle();
                bundle.putString("NAME",name);
                bundle.putString("END",end);
                intent_magic2.putExtras(bundle);
                startActivity(intent_magic2);
            }




        }
    };
}
