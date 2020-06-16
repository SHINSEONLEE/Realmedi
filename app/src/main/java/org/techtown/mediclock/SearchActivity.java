package org.techtown.mediclock;
//SearchActivity

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

public class SearchActivity extends AppCompatActivity {
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
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< Updated upstream
        setContentView(R.layout.activity_search);

        Button QR_searchbtn = findViewById(R.id.QR_searchbtn);
        QR_searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent QR_intent = new Intent(getApplicationContext(), Search_ResultList.class); //일단 바로 검색결과 띄음
                startActivity(QR_intent);
            }
        });

        Button text_searchbtn= findViewById(R.id.text_searchbtn);
        text_searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent text_intent = new Intent (getApplicationContext(), Search_Text.class); //일단 바로 검색결과 띄음
                startActivity(text_intent);
            }
        });



    }
=======
        setContentView(R.layout.fragment_search);
    }
>>>>>>> Stashed changes

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_search, container, false); //container 라는 뷰 안에 첫번째 인자를 넣어줘라, 메모리에 올려준 것

        Button bbutton = rootView.findViewById(R.id.QR_searchbtn);
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.onFragmentChanged(15);
            }
        });
        Button bbutton2 = rootView.findViewById(R.id.photo_searchbtn);
        bbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.onFragmentChanged(15);
            }
        });
        Button bbutton3 = rootView.findViewById(R.id.text_searchbtn);
        bbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.onFragmentChanged(15);
            }
        });
        return rootView;
    }
}*/



@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_search);

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

    Button button1 = findViewById(R.id.QR_searchbtn);
    button1.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent intent_barcode= new Intent(getApplicationContext(), BarcodeActivity.class); //일단 바로 검색결과 띄음
            startActivity(intent_barcode);
        }
    });

    Button button2 = findViewById(R.id.photo_searchbtn);
    button2.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent intent_search_list = new Intent(getApplicationContext(), Search_Photo.class); //일단 바로 검색결과 띄음
            startActivity(intent_search_list);
        }
    });

    Button button3 = findViewById(R.id.text_searchbtn);
    button3.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent intent_search_list = new Intent(getApplicationContext(),  Search_List.class); //일단 바로 검색결과 띄음
            startActivity(intent_search_list);
        }
    });

}
}


