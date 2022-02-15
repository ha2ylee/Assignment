package org.techtown.workerholic;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class GroupRoomActivity extends FragmentActivity {
    public static String groupName;
    public static String name;
    TextView tv1, tv2;
    TabLayout tabs;
    Button btn_write,btn_save;


    Fragment01 fragment1;
    Fragment01_sub fragment1_sub;
    Fragment02 fragment2;
    Fragment02_sub fragment2_sub;
    Fragment03_1 fragment3_1;
    Fragment03_main fragment3;

    //   Fragment01_sub2 fragment1_sub2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_room);
        //코드넘버 받아옴
        Intent intent = getIntent();
        String codeNumber = intent.getStringExtra("codeNumber");
        //파이어베이스 연결
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getInstance().getReference("workerholic");

        // 그룹이름, 날짜 고정 출력
        tv2 = findViewById(R.id.yearandmonth);
        Calendar cal = Calendar.getInstance();
        tv2.setText(cal.get(Calendar.YEAR) +"-"+ (cal.get(Calendar.MONTH)+1) +"-"+ cal.get(Calendar.DATE));




        tv1 = findViewById(R.id.groupText);
        btn_save =findViewById(R.id.btn_save);
        btn_write=findViewById(R.id.btn_write1);

        myRef.child("Group").child(codeNumber).child("name").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                groupName = snapshot.getValue(String.class);
                tv1.setText(groupName);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }//onCancelled
        });

        fragment1 = new Fragment01();
        fragment1_sub = new Fragment01_sub();
//        fragment1_sub2 = new Fragment01_sub2();
        fragment2 = new Fragment02();
        fragment2_sub = new Fragment02_sub();
        fragment3 = new Fragment03_main();
        fragment3_1 = new Fragment03_1();

        //각 fragment로 그룹 코드값 전달
        Bundle bundle = new Bundle();
        bundle.putString("codeNumber",codeNumber);
        fragment1.setArguments(bundle);
        fragment1_sub.setArguments(bundle);
//        fragment1_sub2.setArguments(bundle);
        fragment2.setArguments(bundle);
        fragment2_sub.setArguments(bundle);
        fragment3.setArguments(bundle);
        fragment3_1.setArguments(bundle);


        //시작 프래그먼트 지정
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment1).commit();

        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("NOTICE"));

        tabs.addTab(tabs.newTab().setText("PART-TIME"));
        tabs.addTab(tabs.newTab().setText("SHEET"));
        tabs.getTabAt(0).setIcon(R.drawable.notice);
        tabs.getTabAt(1).setIcon(R.drawable.time);
        tabs.getTabAt(2).setIcon(R.drawable.sheet);

        tabs.setOnTabSelectedListener
                (new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selected = null;
                if(position == 0)
                    selected = fragment1;
                else if(position == 1)
                    selected = fragment2;
                else if(position == 2)
                    selected = fragment3;
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.container,
                                selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    public void onFragmentChange(int index) {
        if(index ==0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        }else if(index ==1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1_sub).commit();

        }
    }
    public void onFragmentChange2(int index) {
        if(index ==0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();

        }else if(index ==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2_sub).commit();

        }
    }
    public void onFragmentChange3to1(int index) {
        if(index ==0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3).commit();

        }else if(index ==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3_1).commit();

        }
    }



}