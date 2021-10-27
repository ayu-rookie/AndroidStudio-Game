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

public class Right extends AppCompatActivity {

    private TextView textView_genie;
    private TextView textView_name;
    private Button button_me;
    int dialogue = 1;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rightpage);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        name = bundle.getString("NAME");

        button_me = (Button) findViewById(R.id.button_me);
        textView_genie = (TextView) findViewById(R.id.textView_genie);
        textView_name = (TextView) findViewById(R.id.textView_name);
        button_me.setOnClickListener(button_meListener);

        textView_name.setText(name);
        requestPermissions();

    }

    private void requestPermissions(){
        if(Build.VERSION.SDK_INT>=23){ // Android 6.0 以上

            int hasPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

            if(hasPermission!= PackageManager.PERMISSION_GRANTED){ // 未取得授權
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
            }
        }
    }

    // 完成權選擇後，呼叫 onRequestPermissionsResult 方法
    // 參數 : 請求授權代碼 名稱 結果
    @Override
    public  void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults){
        if(requestCode==1){
            if(grantResults[0]!=PackageManager.PERMISSION_GRANTED){  // 按 拒絕 按鈕
                Toast.makeText(this,"未取得授權!",
                        Toast.LENGTH_SHORT).show();
                finish();  // 結束程式
            }
        }else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private Button.OnClickListener button_meListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (dialogue == 1) {
                textView_genie.setText("\n" +"津:"+"\n" +"\n" +"「"+name + "大人，您看 ! 」" + "\n" + "\n" +"\n" + "| 在你眼前的..."+ "\n" +"\n"+"| 是一座布滿青苔，"
                        +"\n"+"| 且殘缺不堪的*石製雕像。" +"\n"+"\n"+"| 你估計它存在了數千年之久。"+"\n"+"\n"+ "| 外型似乎是個人的樣子。");
                button_me.setText("...... !");
                dialogue++;
            } else if (dialogue == 2) {
                textView_genie.setText("\n" +"\n" +"| 突然地，"+"\n"+"\n"+"| 雕像發出了強烈的紅光。"+"\n" +"\n" +"\n" +"| 一陣神秘又低沉的聲音，"+"\n" +"\n"+"| 迴盪到你的腦中... ");
                button_me.setText("觸摸雕像");
                dialogue++;
            }
            else if (dialogue == 3) {
                Uri uri2=Uri.parse("tel:666");
                Intent intent2=new Intent(Intent.ACTION_CALL,uri2);
                if(ActivityCompat.checkSelfPermission(
                        Right.this,Manifest.permission.CALL_PHONE)
                        ==PackageManager.PERMISSION_GRANTED){
                    startActivity(intent2);
                }
                textView_genie.setText("   ......"+"\n"+"\n"+"  *聲音："+"\n"+"\n"+"「你是前來*解放我的嗎，」"+"\n"+"\n"+"「孩子?」");
                button_me.setText("(捂頭)嗚..剛才的....那是什麼?");
                dialogue++;
            }
            else if (dialogue == 4) {
                textView_genie.setText("\n"+"\n"+"  *聲音："+"\n"+"\n"+"「孩子，你看到的，」" +"\n"+"\n"+"「是通往*結局的..道路...」");
                button_me.setText("...什麼?");
                dialogue++;
            }
            else if (dialogue == 5) {
                textView_genie.setText("\n"+"\n"+"  *聲音："+"\n"+"\n"+"「至於用法...?」"+"\n"+"\n"+"「我相信你知道該怎麼做。」");
                button_me.setText("...你到底是誰?");
                dialogue++;
            }
            else if (dialogue == 6) {
                textView_genie.setText("\n"+"| 語畢，聲音就消失了..."+"\n"+"\n"+"\n"+"津:"+"\n" +"\n" +"「大人 ! 大人 ! 」" +"\n" +"「嗚嗚..您怎麼又暈過去了...?」 "+"\n" +"\n" +"(☍﹏⁰)"
                        +"\n"+"\n"+"\n" +"| 津一副要哭出來的的樣子");
                button_me.setText("我沒事，津。抱歉讓你擔心了");
                dialogue++;
            }
            else if (dialogue == 7) {
                textView_genie.setText("\n"+"| 轟轟轟..."+"\n"+"\n"+"| 這時，"+"\n"+"\n"+"| 雕像旁的隱藏機緩緩開啟，"+"\n"+"| 出現了一個秘密通道。"
                        +"\n"+"\n"+"\n" +"津:"+"\n" +"\n" +"「大人，這該怎麼辦...?」"+"\n" +"\n"+"| 深吸一口氣.....");
                button_me.setText("我們走吧");
                dialogue++;
            }
            else if (dialogue == 8) {
                Intent intent_door=new Intent();
                intent_door.setClass(Right.this,Magic.class);

                String end="解放";
                Bundle bundle=new Bundle();
                bundle.putString("NAME",name);
                bundle.putString("END",end);
                intent_door.putExtras(bundle);
                startActivity(intent_door);
            }

        }
    };
}

