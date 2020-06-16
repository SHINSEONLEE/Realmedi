package org.techtown.mediclock;
/*<<<<<<< Updated upstream:mediclock/app/src/main/java/company/co/mediclock/Search_ResultList.java

import androidx.appcompat.app.AppCompatActivity;

=======
>>>>>>> Stashed changes:mediclock/app/src/main/java/company/co/mediclock/ShareActiviry.java*/

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

/*<<<<<<< Updated upstream:mediclock/app/src/main/java/company/co/mediclock/Search_ResultList.java
public class Search_ResultList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);
    }
=======
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ShareActiviry extends Fragment {
 /*   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_share);
    }
 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     ViewGroup rootView  = (ViewGroup) inflater.inflate(R.layout.fragment_share, container, false); //container 라는 뷰 안에 첫번째 인자를 넣어줘라, 메모리에 올려준 것

     Button bbutton = rootView.findViewById(R.id.button6);
     bbutton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v){
             MainActivity activity = (MainActivity) getActivity();
             activity.onFragmentChanged(0);
         }
     });
     return rootView;
 }
>>>>>>> Stashed changes:mediclock/app/src/main/java/company/co/mediclock/ShareActiviry.java*/

public class Search_Text extends AppCompatActivity {
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
        setContentView(R.layout.fragment_search__text);

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

        Button button = findViewById(R.id.searchtext_btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent_search_list = new Intent(getApplicationContext(), Search_List.class); //일단 바로 검색결과 띄음
                startActivity(intent_search_list);

            }
        });
    }
}

