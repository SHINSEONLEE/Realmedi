package org.techtown.mediclock;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import static org.techtown.mediclock.Server.getResultFromDB;

public class AlarmList extends AppCompatActivity {

    ActionBar actionBar;

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
        setContentView(R.layout.alarm_list);
        TextView alarmList = (TextView)findViewById(R.id.alarmlist);

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


        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);

        new Server.Show_alarmList( android_id ).execute("http://192.168.23.164:3306/post" );
        alarmList.setText(Server.getResultFromDB());
        //Log.e("DB",Server.getResultFromDB());
        //tvData.setText( Server.getResultFromDB() ); //화면띄우기
    }
}



