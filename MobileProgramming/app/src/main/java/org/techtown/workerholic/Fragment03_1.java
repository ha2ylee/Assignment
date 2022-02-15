package org.techtown.workerholic;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class Fragment03_1 extends Fragment {

    FirebaseAuth mFirebaseAuth; //파이어베이스 인증 처리
    DatabaseReference mDatabaseRef; //실시간 데이터 베이스
    GroupRoomActivity activity;
    String codeNumber, worker_name;
    String notice;
    EditText[] edit_date = new EditText[20];
    EditText[] edit_time = new EditText[20];
    String[] date = new String[20];
    String[] time = new String[20];

    String[] datename = new String[20];
    String[] timename = new String[20];
    String wage ="0";
    Double result=0.0;



    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        activity = (GroupRoomActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //파이어베이스 연결
        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("workerholic");

        //fragment.xml 가져옴
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_fragment03_1, container, false);

        //GroupRoomActivity로부터 값을 가져온다.
        Bundle extra = this.getArguments();
        if(extra != null) {
            extra = getArguments();
            codeNumber = extra.getString("codeNumber");
            worker_name = extra.getString("name0");

        }

        // 우선, db에 저장된 내용들 가져옴
        Integer[] Rid_date = {
                R.id.date0, R.id.date1, R.id.date2, R.id.date3, R.id.date4,R.id.date5,
                R.id.date6, R.id.date7, R.id.date8,
                R.id.date9, R.id.date10, R.id.date11, R.id.date12,R.id.date13,
                R.id.date14, R.id.date15, R.id.date16,
                R.id.date17, R.id.date18, R.id.date19

        };
        Integer[] Rid_time = {
                R.id.time0, R.id.time1, R.id.time2, R.id.time3, R.id.time4,R.id.time5,
                R.id.time6, R.id.time7, R.id.time8,
                R.id.time9, R.id.time10, R.id.time11, R.id.time12,R.id.time13,
                R.id.time14, R.id.time15, R.id.time16,
                R.id.time17, R.id.time18,R.id.time19

        };
        for(int i =0; i<Rid_date.length;i++){
            edit_date[i]= (EditText) rootView.findViewById(Rid_date[i]);
        }

        for(int i=0; i<Rid_time.length; i++){
            edit_time[i] = (EditText) rootView.findViewById(Rid_time[i]);

        }

        for(int i=0; i<Rid_date.length; i++){
            date[i] ="date"+i;

        }
        for(int i=0; i<Rid_time.length; i++){
            time[i] ="time"+i;

        }


        //db에서 불러오기

            mDatabaseRef.child("WageData").child(codeNumber).child(date[0]).addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                        edit_date[0].setText(snapshot.getValue(String.class));

                }


                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }//onCancelled
            });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[1]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[1].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[2]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[2].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[3]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[3].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[4]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[4].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[5]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[5].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[6]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[6].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[7]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[7].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[8]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[8].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[9]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[9].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[10]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[10].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[11]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[11].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[12]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[12].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[13]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[13].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[14]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[14].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[15]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[15].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[16]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[16].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });

        mDatabaseRef.child("WageData").child(codeNumber).child(date[17]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[17].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[18]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[18].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(date[19]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_date[19].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });




        mDatabaseRef.child("WageData").child(codeNumber).child(time[0]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[0].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(time[1]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[1].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(time[2]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[2].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(time[3]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[3].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(time[4]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[4].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(time[5]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[5].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(time[6]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[6].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(time[7]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[7].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(time[8]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[8].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });

        mDatabaseRef.child("WageData").child(codeNumber).child(time[9]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[9].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });

        mDatabaseRef.child("WageData").child(codeNumber).child(time[10]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[10].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });

        mDatabaseRef.child("WageData").child(codeNumber).child(time[11]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[11].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });

        mDatabaseRef.child("WageData").child(codeNumber).child(time[12]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[12].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });

        mDatabaseRef.child("WageData").child(codeNumber).child(time[13]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[13].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });

        mDatabaseRef.child("WageData").child(codeNumber).child(time[14]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[14].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });

        mDatabaseRef.child("WageData").child(codeNumber).child(time[15]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[15].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(time[16]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[16].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });

        mDatabaseRef.child("WageData").child(codeNumber).child(time[17]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[17].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });

        mDatabaseRef.child("WageData").child(codeNumber).child(time[18]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[18].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("WageData").child(codeNumber).child(time[19]).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                edit_time[19].setText(snapshot.getValue(String.class));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });






        //저장 버튼 누르면 edittext에 썼던 내용이 실시간db에 저장됨
        Button btn_save = (Button) rootView.findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<Rid_date.length; i++){
                    datename[i] = edit_date[i].getText().toString();
                    timename[i] = edit_time[i].getText().toString();
                    mDatabaseRef.child("WageData").child(codeNumber).child(date[i]).setValue(datename[i]);
                    mDatabaseRef.child("WageData").child(codeNumber).child(time[i]).setValue(timename[i]);


                }



                Toast.makeText(getActivity(), "저장되었습니다.", Toast.LENGTH_SHORT).show();



            }
        });
        TextView total = (TextView)rootView.findViewById(R.id.total);
        EditText hour_wage =(EditText) rootView.findViewById(R.id.money);

        //시급 계산
        Button btn_cal = (Button) rootView.findViewById(R.id.btn_cal);
        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wage = hour_wage.getText().toString().trim();

                if(wage.isEmpty()){
                    Toast.makeText(getActivity(), "시급을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }else{
                    for(int i=0;i<Rid_time.length; i++) {
                        timename[i] = edit_time[i].getText().toString();
                        if(timename[i].isEmpty()){
                            timename[i] ="0";
                        }
                        result += Double.parseDouble(timename[i]);
                    }
                    result = result * Double.parseDouble(wage);
                    total.setText(result.toString());
                    result =0.0;
                }

            }
        });


        return rootView;
    }
}