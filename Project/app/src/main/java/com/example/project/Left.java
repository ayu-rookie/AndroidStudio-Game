package com.example.project;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MenuItem;
import android.view.ContextMenu;
import android.graphics.Color;

public class Left extends AppCompatActivity {

    ConstraintLayout myLayout;
    private TextView textView_genie;
    private TextView textView_magic2,textView_magic;
    private TextView textView_name,textView_code;
    private Button button_me;
    int dialogue = 1;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leftpage);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        name = bundle.getString("NAME");

        button_me = (Button) findViewById(R.id.button_me);
        textView_genie = (TextView) findViewById(R.id.textView_genie);
        textView_magic2 = (TextView) findViewById(R.id.textView_magic2);
        textView_magic = (TextView) findViewById(R.id.textView_magic);
        textView_code = (TextView) findViewById(R.id.textView_code);
        textView_name = (TextView) findViewById(R.id.textView_name);
        button_me.setOnClickListener(button_meListener);
        myLayout=(ConstraintLayout)findViewById(R.id.myLayout);

        textView_name.setText(name);
        registerForContextMenu(textView_magic2);
        registerForContextMenu(textView_magic);

    }
    protected static final int MENU_GREENCOLOR= Menu.FIRST;
    protected static final int MENU_REDCOLOR= Menu.FIRST+1;
    protected static final int MENU_GOLDCOLOR= Menu.FIRST+2;
    protected static final int MENU_TEXT= Menu.FIRST+3;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v==textView_magic2){

            menu.add(0,MENU_REDCOLOR ,1,"火神領域");
            menu.add(0,MENU_GOLDCOLOR ,2,"光斂混元");
            menu.add(0,MENU_GREENCOLOR ,3,"青龍氣息");

        }
        if (v==textView_magic){

            menu.add(0,MENU_TEXT ,1,"轉換文字");


        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_GREENCOLOR:
                textView_code.setBackgroundColor(Color.GREEN);
                textView_genie.setText("\n"+"\n"+"  *文字:"+"\n"+"\n"+"「道路前，」"+"\n" +"\n" +"「願汝心純粹之如蒼色，」"+"\n" +"「*釋放於於大地。」"+"\n" +"\n" +"\n" +"津:"+"\n" +"\n" +"「團長大人 ! 這魔法太酷啦 ! !」");
                button_me.setText("這是，古代魔碼...?");
                textView_magic2.setVisibility(View.INVISIBLE);
                break;
            case MENU_GOLDCOLOR:
                Toast wrong = Toast.makeText(Left.this, "不對，不是這個", Toast.LENGTH_LONG);
                wrong.show();
                break;
            case MENU_REDCOLOR:
                Toast wrong2 = Toast.makeText(Left.this, "(´-﹏-`；)", Toast.LENGTH_LONG);
                wrong2.show();
                break;
            case MENU_TEXT:
                textView_genie.setText("\n"+"\n"+"  *文字:"+"\n"+"\n"+"「道路前，」"+"\n" +"\n" +"「願汝心純粹之如蒼色，」"+"\n" +"「*釋放於大地。」"+"\n" +"\n" +"\n" +"津:"+"\n" +"\n" +"「太厲害啦 ! ! ! ! ! 」"+"\n" +"「真不愧是團長大人!  Σ(*ﾟдﾟﾉ)ﾉ」");
                button_me.setText("嗯......我懂了");
                textView_magic.setVisibility(View.INVISIBLE);
        }
        return super.onContextItemSelected(item);
    }


    private Button.OnClickListener button_meListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (dialogue == 1) {
                textView_genie.setText("\n" +"津:"+"\n" +"\n" +"「"+name + "大人，您看 !」" + "\n" + "\n" +"\n" + "| 在你眼前的...，"+"\n" + "\n" +"| 是一塊長滿灰塵，"
                        +"\n"+"| 且殘缺不堪的*石製板子。" +"\n"+"\n"+"| 你估計它存在了數千年之久。"+"\n"+"\n"+ "| 上面似乎還寫了些什麼...。");
                button_me.setText("仔細看石板上的文字");
                dialogue++;
            } else if (dialogue == 2) {
                textView_genie.setText("\n"+"\n"+"  *文字:"+"\n"+"\n"+"「$%^&，」"+"\n" +"\n" +"「^$%^%(_(*，」"+"\n" +"「*+*(&*^08_)@&。」"+"\n"+"\n"+"\n"+"津:"+"\n" +"\n" +"「看不懂呢...」");
                button_me.setText("...這是古代語");
                dialogue++;
            }
            else if (dialogue == 3) {
                textView_magic.setVisibility(View.VISIBLE);
                textView_genie.setText("\n"+"\n"+"  *文字:"+"\n"+"\n"+"「$%^&，」"+"\n" +"\n" +"「^$%^%(_(*，」"+"\n" +"「*+*(&*^08_)@&。」"+"\n"+"\n"+"\n"+"津:"+"\n" +"\n" +"「看不懂呢...」");

                dialogue++;
            }
            else if (dialogue == 4) {
                textView_magic.setVisibility(View.INVISIBLE);
                textView_genie.setText("\n"+"\n"+"  *文字:"+"\n"+"\n"+"「道路前，」"+"\n" +"\n" +"「願汝心懷純粹蒼色，」"+"\n" +"「*釋放吾之大地。」"+"\n" +"\n" +"\n" +"津:"+"\n" +"\n" +"「大人，這是什麼意思呢...?」");
                button_me.setText("我想我知道該怎麼做");
                dialogue++;
            }
            else if (dialogue == 5) {
                textView_magic2.setVisibility(View.VISIBLE);

                dialogue++;
            }
            else if (dialogue == 6) {
                textView_code.setVisibility(View.INVISIBLE);
                textView_genie.setText("| 轟轟轟..."+"\n"+"\n"+"| 這時，"+"\n"+"\n"+"| 石板旁的隱藏門緩緩開啟，"+"\n"+"| 出現了一個秘密通道。"
                        +"\n"+"\n"+"\n" +"津:"+"\n" +"\n" +"「大人，這該怎麼辦...?」"+"\n" +"\n"+"| 你深吸一口氣.....");
                button_me.setText("我們走吧");
                dialogue++;
            }
            else if (dialogue == 7) {
                Intent intent_door=new Intent();
                intent_door.setClass(Left.this,Magic.class);

                String end="釋放";
                Bundle bundle=new Bundle();
                bundle.putString("NAME",name);
                bundle.putString("END",end);
                intent_door.putExtras(bundle);
                startActivity(intent_door);
            }

        }
    };
}

