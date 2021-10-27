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
public class GoodEnd extends AppCompatActivity{

    private TextView textView_genie;
    private TextView textView_name;
    private Button button_me;
    public MediaPlayer mediaplayer;
    int dialogue = 1;
    String name = "",end="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goodendpage);

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
                mediaplayer= MediaPlayer.create(GoodEnd.this, R.raw.good2); //播放歌曲源
                mediaplayer.start();
                textView_genie.setText("\n" +"| 餘光，你看見了一個人影..."+"\n" +"\n" +"\n" +"某人:" +   "\n" + "\n" + "「吾之釋放者 "+name+" 啊 ! 」"+ "\n" +"\n" +"「吾名乃是*羅忒．卡萊。」");
                button_me.setText("羅忒．卡萊 ? ! ");
                dialogue++;
            }
            else if (dialogue == 2) {
                textView_genie.setText("\n" +"津:"+"\n" +"\n" +"「羅忒．卡萊...?  Σ(っ°Д°;)っ」" +"\n" +"\n" +"「那不就那位王國有史以來，」"+"\n" +"「最強的魔法師皇帝嗎 ! ?」"+"\n" +"\n"+"\n" +
                        "羅忒:" + "\n" + "\n" + "「後人是這稱呼吾的嗎...?」");
                button_me.setText("但您不是早就在討伐魔王*紅蓮．菲"+"\n" +"的戰爭中消失了嗎...?");
                dialogue++;
            }
            else if (dialogue == 3) {
                textView_genie.setText("\n" +"羅忒:"+"\n" +"\n" +"「沒錯，」" +"\n" +"「那場戰爭，使吾等兩敗俱傷。」"+"\n" +"\n" +
                        "「一直持續到最終...」"+"\n" +"\n" +"「吾以吾的靈魂為代價，」"+"\n" +"\n" +"「用封印陣..」"+"\n" +"「將菲的靈魂一同封印在塔中。」"+"\n" +"\n" +"「...才得以了結。」");
                button_me.setText("那麼您為何會召喚我...?");
                dialogue++;
            }
            else if (dialogue == 4) {
                textView_genie.setText("\n" +"羅忒:"+"\n" +"\n" +"「吾一直在等待，」" +"\n" +"\n" +"「命運之人將吾釋放出來。」"+"\n" +"\n" +"\n"+"「並且，此人將能夠與吾，」"+"\n"+
                        "「一同淨化菲的靈魂，」"+"\n" +"\n" +"\n"+"「你願意幫助我嗎，"+name+" ...?」");
                button_me.setText("我很樂意為您效勞");
                dialogue++;
            }
            else if (dialogue == 5) {
                textView_genie.setText("\n" +"羅忒:"+"\n" +"\n" +"「那我們開始吧。」" +"\n" +"\n" +"\n"+"\n" +" | 你與羅忒伸出雙手"+"\n" +" | 面對封印陣。"+"\n"+"\n" +"「淨化。」");
                button_me.setText("淨化");
                dialogue++;
            }
            else if (dialogue == 6) {
                textView_genie.setText("\n" +"| 淨化帶來的溫暖綠光，"+"\n" +"| 讓你感覺身心舒暢..."+"\n" +"\n" +"| 但是，突然間，"+"\n" +"\n" +"| 你感覺到了有強大的魔力，"+"\n" +"| 正不斷的在你體內增長..." +"\n" +"\n" +"\n"+"羅忒:"+"\n"+"\n"+
                        "「這些魔力，」" +"\n" +"「就交給你了.....」");
                button_me.setText("這...這不可以啊 ! 陛下");
                dialogue++;
            }
            else if (dialogue == 7) {
                textView_genie.setText("\n" +"| 隨著淨化魔法漸漸完成，"+"\n" +"\n" +"| 羅忒的形體也慢慢地消逝.....");
                button_me.setText("羅忒陛下!");
                dialogue++;
            }
            else if (dialogue == 8) {
                textView_genie.setText("\n" +"羅忒:"+"\n" +"\n" +"「千年的等待，」"+"\n" +"「已經慢慢消逝了我的靈魂...」" +"\n" +"\n" +"「時間不多了...」"+"\n" +"\n" +"\n" +"「我相信你會好好使用它的，」" +"\n" +"\n" +"「去幫助更多的人吧...!」");
                button_me.setText("陛下...!");
                dialogue++;
            }
            else if (dialogue == 9) {
                textView_genie.setText("\n" +"| 嘩......."+"\n" +"\n" +"\n" +"| 淨化魔法成功了.."+"\n" +"\n" +"| 一切都恢復了原狀，"+"\n" +"| 彷彿什麼都不曾發生..."+"\n" +"\n" +"\n" +"津:"+"\n" +"\n" +"「封印陣，」"+"\n" +"「...還有羅忒大人都消失了...」" );
                button_me.setText("陛下，請您放心，"+"\n"+"我一定會好好使用這些魔力的");
                dialogue++;
            }
            else if (dialogue == 10) {
                textView_genie.setText("\n" +"| 兩個月後，"+"\n" +"\n" +"| 你們回到了王國卡萊，"+"\n" +"\n" +"| 並且，"+"\n" +"\n" +"| 你運用了你強大的魔力，"+"\n" +"| 隻身守護了王國，"+"\n" +"\n" +"| 免於魔王殘黨的侵害...");
                button_me.setText(".....");
                dialogue++;
            }
            else if (dialogue == 11) {
                textView_genie.setText("\n" +"\n" +"| 從此，"+"\n" +"\n" +"\n" +"| 王國的歷史書，"+"\n" +"| 上寫下了一個名字..."
                        +"\n"+"\n"+"\n" +"\n" +"  - "+name+"，「卡萊的守護者」");
                button_me.setText(".....");
                dialogue++;
            }
            else if (dialogue == 12) {
                textView_genie.setText("結局一"+"\n"+"\n"+"「卡萊的守護者」" );
                button_me.setText("感謝遊玩 σ`∀´)σ");
                dialogue++;
            }

        }
    };
}
