package org.techtown.mediclock;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.support.v4.app.*;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class SeecodeActivity extends AppCompatActivity {
    ActionBar actionBar;

    //private static String TAG = "휴대폰 정보 가져오기";
    //final TextView seecode = (TextView) findViewById(R.id.seecode);

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
        setContentView(R.layout.fragment_seecode);

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

        TextView seecode = findViewById(R.id.seecode);
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        String android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);

        //Log.d(TAG, android_id);
        // String android_id="088738928";
        //int id2 = Integer.parseInt(android_id);
         seecode.setText(android_id);

    }
}

