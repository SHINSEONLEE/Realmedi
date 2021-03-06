package org.techtown.mediclock;

import android.app.AppComponentFactory;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Mainmenu extends AppCompatActivity {
    private  static Context context;


    ActionBar actionBar;

    /*
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle presses on the action bar items
            switch (item.getItemId()) {
                case R.id.home:
                    Intent intent_home = new Intent(getApplicationContext(), Mainmenu.class);
                    startActivity(intent_home);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }//홈 화면 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //or switch문을 이용하면 될듯 하다.
        if (id == R.id.gotohome) {
            Intent homeIntent = new Intent(this, Mainmenu.class);
            startActivity(homeIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mainmenu);
        Mainmenu.context = getApplicationContext();

        actionBar = getSupportActionBar();
        //actionBar.setLogo(R.drawable.home2); 약묵자 로고 넣으면 좋을 것 같은데
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_USE_LOGO);


        //액션바 설정하기//
        //액션바 타이틀 변경하기
        getSupportActionBar().setTitle("App");
        //액션바 배경색 변경#368AFF
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF339999));
        //홈버튼 표시
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);




/*
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_search :
                    // TODO : process the click event for action_search item.
                    return true ;
                // ...
                // ...
                default :
                    return super.onOptionsItemSelected(item) ;
            }
        }*/
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_searchactivity = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent_searchactivity);
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_medimorning = new Intent(getApplicationContext(), Medimorning.class);
                startActivity(intent_medimorning);
            }
        });
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_mediname = new Intent(getApplicationContext(), Mediname.class);
                startActivity(intent_mediname);
            }
        });
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_sharealarm = new Intent(getApplicationContext(), ShareAlarm.class);
                startActivity(intent_sharealarm);
            }
        });
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_description = new Intent(getApplicationContext(), Description.class);
                startActivity(intent_description);
            }
        });

    }
    public static Context getAppContext() {
        return Mainmenu.context;
    }
}
