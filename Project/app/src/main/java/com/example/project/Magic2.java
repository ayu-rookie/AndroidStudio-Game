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
import android.widget.TextView;
import android.widget.Toast;


public class Magic2 extends AppCompatActivity {

    private TextView textView_genie;
    private TextView textView_name;
    private Button button_me;
    private ImageView imageView_magic;
    int dialogue = 1;
    String name = "",end="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magic2page);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        name = bundle.getString("NAME");
        end = bundle.getString("END");


        button_me = (Button) findViewById(R.id.button_me);
        textView_genie = (TextView) findViewById(R.id.textView_genie);
        textView_name = (TextView) findViewById(R.id.textView_name);
        imageView_magic=(ImageView)findViewById(R.id.imageView_magic);
        button_me.setOnClickListener(button_meListener);


        textView_name.setText(name);
    }

    private Button.OnClickListener button_meListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (dialogue == 1) {
                textView_genie.setText("");
                imageView_magic.setVisibility(View.VISIBLE);
                button_me.setText("就是你在呼喚我的吧");
                dialogue++;
            }
            else if(dialogue==2){
                imageView_magic.setVisibility(View.INVISIBLE);
                textView_genie.setText("\n"  +"| 你找到了那個魔法的來源，"+"\n" +"\n"+ "| 是一個藍色光芒的魔法陣。" + "\n" +"\n" + "| 那個陣形你在古書上見到過..."+"\n" +"\n" +"\n"+"\n"+"津:"+"\n" +"\n"+"「" +name+"大人，這是什麼...?」");
                button_me.setText("是古代封印陣");
                dialogue++;
            }
            else if (dialogue == 3) {
                textView_genie.setTextColor(Color.parseColor("#66CCFF"));
                textView_genie.setText("\n"  +"| 像是感覺到有人來了，"+"\n" +"\n" + "| 藍色魔法陣的光芒越來越大....."+"\n" +"\n"+"\n"+
                        "津:"+"\n" +"\n" +"「哇...! 好亮 ! 」"+"\n" +"「快看不見了 !   (つд⊂) 」");
                button_me.setText("好強大的魔力 !");
                dialogue++;
            }
            else if (dialogue == 4) {
                textView_genie.setText("\n"+"| 過了幾秒鐘後，"+"\n" + "| 你漸漸的可以看清楚周圍，"
                        +"\n" +"\n" +"\n" +"| 但你卻發現，"+"\n" +"\n" +"| 整個空間，"+"\n"+"| 竟然在不知不覺中，"+"\n" +"\n" +"| 被藍色光芒完全壟罩住..."
                        +"\n" +"\n" +"\n" +"「.....」");
                button_me.setText("? !");
                dialogue++;
            }
            else if (dialogue == 5) {
                textView_genie.setText("\n" +"\n" +"  *某個聲音:"+"\n" +"\n" +"「你總算來了.....」");
                button_me.setText("你就是這些魔力的主人嗎?");
                dialogue++;
            }
            else if (dialogue == 6) {
                textView_genie.setText("\n" +"\n" +"  *某個聲音:"+"\n" +"\n" +"「我是誰...?」"+"\n" +"「等等..你會知道的。」"
                                +"\n"+"\n" +"\n" +"\n" +"「現在，」"+"\n" +"\n"+"「 *"+end+" 我吧 !」");
                button_me.setText("什麼 ! ?");
                dialogue++;
            }
            else if (dialogue == 7) {
                Intent intent_code=new Intent();
                intent_code.setClass(Magic2.this,EndCode.class);

                Bundle bundle=new Bundle();
                bundle.putString("NAME",name);
                bundle.putString("END",end);
                intent_code.putExtras(bundle);
                startActivity(intent_code);
            }




        }
    };


}
