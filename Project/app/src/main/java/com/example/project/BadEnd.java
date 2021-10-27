package com.example.project;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
public class BadEnd extends AppCompatActivity{

    private TextView textView_genie;
    private TextView textView_name;
    private Button button_me;
    public MediaPlayer mediaplayer;
    int dialogue = 1;
    String name = "",end="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.badendpage);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        name = bundle.getString("NAME");
        end = bundle.getString("END");

        button_me = (Button) findViewById(R.id.button_me);
        textView_genie = (TextView) findViewById(R.id.textView_genie);
        textView_name = (TextView) findViewById(R.id.textView_name);
        button_me.setOnClickListener(button_meListener);
        mediaplayer=new MediaPlayer();

        textView_name.setText(name);
    }

    private Button.OnClickListener button_meListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (dialogue == 1) {
                mediaplayer.reset();
                mediaplayer= MediaPlayer.create(BadEnd.this, R.raw.bad2); //播放歌曲源
                mediaplayer.start();
                textView_genie.setText("\n" +"| 蹦... !"+"\n" +"| 傳來了一聲巨響..."+"\n" +"\n" +"\n" +"津:"+"\n" +"\n" +"「啊....扼......」" +"\n" +"\n" +"| 一道衝擊波將津打倒在地...");
                button_me.setText("津 ! ! ! ");
                dialogue++;
            }

            else if (dialogue == 2) {
                textView_genie.setText("\n" +"| 餘光，你看見了一個人影..."+"\n" +"\n" +"\n" +"某人:" +   "\n" + "\n" +"「終於啊...」"+ "\n" +"「我終於自由了...! 」"+ "\n" +"\n" +"\n" +"「哈哈哈.. 哈哈哈哈...!」");
                button_me.setText("你是誰 ! ! ! ");
                dialogue++;
            }
            else if (dialogue == 3) {
                textView_genie.setText("\n"  +"某人:" +   "\n" + "\n" +"「你就是，」"+"\n" +"「解放我的那個傢伙吧...?」"
                        +"\n" +"\n" +"「呵呵...」" + "\n" +"\n" +"「反正，」"+"\n" +"「你很快就會消失了，」"+ "\n" +"\n" +"「告訴你也無所謂喔。」");
                button_me.setText("消失 ? 什麼意思 ?" );
                dialogue++;
            }
            else if (dialogue == 4) {
                textView_genie.setText("\n"  +"某人:" +   "\n" + "\n" +"「沒錯喔...」"
                        + "\n" +"\n" +"「你的身體呀，」"+ "\n" +"\n" +"「馬上...」"+"\n" +"「就會變成，」"+"\n" + "\n"+"\n"+"「我...紅蓮．菲的容器了喔...」");
                button_me.setText("紅蓮．菲 ? ! ! ");
                dialogue++;
            }
            else if (dialogue == 5) {
                textView_genie.setText("\n" +"紅蓮:" +   "\n" + "\n" +"「哈哈哈...」"+"\n" +"「看來我很有名呢... ! 」"
                        + "\n" +"\n" +"「那我再告訴你吧 !」"+ "\n" +"\n" +"\n"  +"「三千年前，」"+"\n" +"「那個可愛的卡萊皇帝...」");
                button_me.setText(".....");
                dialogue++;
            }
            else if (dialogue == 6) {
                textView_genie.setText("\n" +"紅蓮:" +   "\n" + "\n"+"「他竟然天真的認為，」"+"\n"+"\n"  +"「只靠他一個人的靈魂，」"+"\n"  +"「就可以把我封印起來耶...」"
                        +"\n" +"\n"+"\n"+"「他不知道，」"+"\n" +"\n"+"「我早就布置好陷阱了呢...」");
                button_me.setText("難道...那個呼喚?");
                dialogue++;
            }
            else if (dialogue == 7) {
                textView_genie.setText( "\n" +"紅蓮:" +   "\n" + "\n"+"「沒錯喔 ! 」"+"\n"+"\n"+"「那是我在誘惑你呦...」"+"\n"+"\n"+"「我啊，」"+"\n"+"「一直一直在等，」"
                        +"\n" +"\n" +"「像你這樣的..」"+"\n"+"「強大的容器出現...」");
                button_me.setText(".....");
                dialogue++;
            }
            else if (dialogue == 8) {
                textView_genie.setText( "\n" +"紅蓮:" +   "\n" + "\n"+"「呵呵...」"+"\n"+"\n"+"「你真的讓我等的好久啊，」"+"\n"+"「小朋友...」"+"\n" +"\n"+"\n"+" | 紅蓮美麗的臉龐微笑著，"+"\n"+"\n"+" | 但你卻感覺不寒而慄。");
                button_me.setText(".....");
                dialogue++;
            }
            else if (dialogue == 9) {
                textView_genie.setText("\n" +"\n" +"紅蓮:" +   "\n" + "\n"+"「好啦，」"+"\n"+"「我們也聊得夠久了...」"
                        +"\n" +"\n"+"\n"+"\n"+"「"+ name+"，」"+"\n" +"\n"+"「要想我喔 ! 」");
                button_me.setText(".....");
                dialogue++;
            }
            else if (dialogue ==10) {
                textView_genie.setText("\n" +"\n" +"| 一瞬間，"+"\n" +"| 你的身體被拋向了半空中，"+"\n" +"\n" +"| 最後一點意識.."+"\n" +"\n" +"| 也漸漸地消失.....");
                button_me.setText(".....");
                dialogue++;
            }
            else if (dialogue ==11) {
                textView_name.setText(name+"?");
                textView_genie.setText(".....");
                button_me.setText(".....");
                dialogue++;
            }
            else if (dialogue ==12) {
                textView_name.setText("紅蓮");
                textView_genie.setText("");
                button_me.setText("好了..現在做什麼好呢...?");
                dialogue++;
            }
            else if (dialogue ==13) {
                textView_name.setVisibility(View.INVISIBLE);
                textView_genie.setText("結局二"+"\n"+"\n"+"「世界末日」");
                button_me.setText("感謝遊玩 ヽ( ° ▽°)ノ");
                dialogue++;
            }
            else if (dialogue ==14) {
                finish();
            }


        }
    };
}


