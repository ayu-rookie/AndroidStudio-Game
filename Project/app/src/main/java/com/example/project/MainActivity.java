package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView_genie;
    private TextView textView_genie2;
    private TextView textView_name;
    private Button button_me, button_me2,button_me3;
    private EditText editText_name;
    int dialogue = 1;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_me = (Button) findViewById(R.id.button_me);
        button_me2=(Button)findViewById(R.id.button_me2);
        textView_genie = (TextView) findViewById(R.id.textView_genie);
        textView_genie2 = (TextView) findViewById(R.id.textView_genie2);
        textView_name = (TextView) findViewById(R.id.textView_name);
        editText_name = (EditText) findViewById(R.id.editText_name);
        button_me.setOnClickListener(button_meListener);
        button_me2.setOnClickListener(button_me2Listener);

    }

    private Button.OnClickListener button_meListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (dialogue == 1) {
                textView_genie.setText("\n" +"某人:"+"\n" +"\n" +"「大人...?」");
                button_me.setText("...?");
                dialogue++;
            } else if (dialogue == 2) {
                textView_genie.setText("\n" +"某人:"+"\n" +"\n" +"「您醒了嗎..? 太好了 ! 」");
                button_me.setText("我..是誰...? 我在哪裡...?");
                dialogue++;
            } else if (dialogue == 3) {
                textView_genie.setText("\n" +"某人:"+"\n" +"\n" +"  ..." + "\n" + "\n" + "「難道您失去記憶了嗎?」" + "\n" + "\n" + "「您是卡萊的魔法師團長，」" + "\n" +"\n" +"\n" +  "  您是...");
                editText_name.setVisibility(View.VISIBLE);
                textView_genie2.setVisibility(View.VISIBLE);
                button_me.setText("嗯?是啊..? 沒錯..這確實是我的名字");

                dialogue++;
            } else if (dialogue == 4) {
                name += editText_name.getText().toString();
                if (name == "") {
                    Toast youforget = Toast.makeText(MainActivity.this, "還沒想起來嗎?", Toast.LENGTH_LONG);
                    youforget.show();
                    finish();
                }

                editText_name.setVisibility(View.INVISIBLE);
                textView_genie2.setVisibility(View.INVISIBLE);
                textView_name.setVisibility(View.VISIBLE);
                textView_name.setText(name);
                textView_genie.setText("\n" +"某人:"+"\n" +"\n" +"「這樣啊...」" + "\n" + "\n" + "「看來您似乎還沒清醒，」" + "\n" +"\n" + "\n" + "\n" +"「那讓我來跟您解釋一下，」" + "\n" +"\n" + "「目前所有的狀況吧 ! 」");
                button_me.setText("啊..那就麻煩你了");
                dialogue++;
            } else if (dialogue == 5) {
                textView_genie.setText("\n" +"津:"+"\n" +"\n" +"「大人，我是您的隨從 - 津，」" + "\n" +  "\n" + "「前幾日，」" + "\n" + "\n" + "「在您探訪古大陸的旅途中，」"
                        + "\n" + "「您發現了一座神秘的高塔。」"+ "\n" + "\n" +"\n" +"「因為 *感受到了塔的呼喚，」"+"\n"+ "\n" +"「您便決定進入古塔......」");
                button_me.setText("嗯... ￣︿￣");
                dialogue++;

            } else if (dialogue == 6) {
                textView_genie.setText("\n" +"津:"+"\n" +"\n" +"「但，沒有絲毫的徵兆，」"+ "\n"+ "\n"+"「我們一入塔內，」"+"\n" + "「便被一個強大的魔法突襲，」" + "\n" + "\n" + "\n" + "「但就當您在試圖破解時，」"
                        + "\n" + "\n" + "「那股*力量卻像早有預謀般，」"+ "\n" +"\n" +"「將您的魔力反噬....」" );
                button_me.setText("對，沒錯 ! 那股魔力.....");
                dialogue++;

            }
            else if (dialogue == 7) {
                textView_genie.setText("\n" +"| 那是你從未見過的，"+"\n" +"\n" +"| 強大的魔力....."+"\n" + "\n" +"\n" +"津:"+"\n" +"\n" + "「然後等我清醒過來...」"
                        + "\n" + "\n" +"\n" + "「就發現我與" + name + "大人您一起，」" + "\n" + "「被封印在了這裡。」");
                button_me.setText("我全都想起來了");
                dialogue++;

            }
            else if (dialogue == 8) {
                textView_genie.setText("\n" +"\n" +"津:"+"\n" +"\n" +"「呼 ! 」"+"\n" +"「您能回想起來實在太好了 ! 」" + "\n" + "\n" + "٩(๑❛ᴗ❛๑)۶，" + "\n" + "\n" +"\n" + "「那..請問大人，」" + "\n" + "\n" + "「我們現在該怎麼辦呢...?」");
                button_me.setText("先觀察一下環境吧!");
                dialogue++;
            }
            else if (dialogue == 9) {
                textView_name.setVisibility(View.INVISIBLE);
                textView_genie.setText("津:"+"\n" +"\n" +"「是的，魔法師團長"+ name +"大人 ! 」"+ "\n" + "\n" + "(*´∀`)~♥" + "\n" + "\n" + "「在大人您昏睡的這段期間，」" + "\n" + "「我稍微地觀察了一下環境，」"
                        + "\n" + "\n" +"\n" + "「這裡有左右兩條通道可以走，」" +  "\n" +  "\n" +"「請問您希望先調查哪邊呢?」");
                button_me2.setVisibility(View.VISIBLE);
                button_me.setText("遠處有微微綠光的左通道");
                dialogue++;
            }
            else if (dialogue == 10) {
                Intent intent_good=new Intent();
                intent_good.setClass(MainActivity.this,Left.class);

                Bundle bundle=new Bundle();
                bundle.putString("NAME",name);
                intent_good.putExtras(bundle);
                startActivity(intent_good);
            }

        }
    };

    private Button.OnClickListener button_me2Listener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent_bad=new Intent();
            intent_bad.setClass(MainActivity.this,Right.class);

            Bundle bundle=new Bundle();
            bundle.putString("NAME",name);
            intent_bad.putExtras(bundle);
            startActivity(intent_bad);
        }
    };
}
