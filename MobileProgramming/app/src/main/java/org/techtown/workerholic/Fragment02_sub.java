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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class Fragment02_sub extends Fragment {
    FirebaseAuth mFirebaseAuth; //파이어베이스 인증 처리
    DatabaseReference mDatabaseRef; //실시간 데이터 베이스
    GroupRoomActivity activity;
    String codeNumber;
    String part1start,part1end,part1edt,part2start,part2end,part2edt,part3start,part3end,part3edt,part4start,part4end,part4edt;


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
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_fragment02_sub, container, false);

        //GroupRoomActivity로부터 값을 가져온다.
        Bundle extra = this.getArguments();
        if(extra != null) {
            extra = getArguments();
            codeNumber = extra.getString("codeNumber");

        }
        // 우선, db에 저장된 내용들 가져옴
        TextView part1_start = (TextView) rootView.findViewById(R.id.part1_start);
        TextView part1_end = (TextView) rootView.findViewById(R.id.part1_end);
        TextView part2_start = (TextView) rootView.findViewById(R.id.part2_start);
        TextView part2_end = (TextView) rootView.findViewById(R.id.part2_end);
        TextView part3_start = (TextView) rootView.findViewById(R.id.part3_start);
        TextView part3_end = (TextView) rootView.findViewById(R.id.part3_end);
        TextView part4_start = (TextView) rootView.findViewById(R.id.part4_start);
        TextView part4_end = (TextView) rootView.findViewById(R.id.part4_end);
        EditText part1_edt = (EditText) rootView.findViewById(R.id.part1_edt);
        EditText part2_edt = (EditText) rootView.findViewById(R.id.part2_edt);
        EditText part3_edt = (EditText) rootView.findViewById(R.id.part3_edt);
        EditText part4_edt = (EditText) rootView.findViewById(R.id.part4_edt);

        mDatabaseRef.child("Group").child(codeNumber).child("part1_start").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                part1start = snapshot.getValue(String.class);
                part1_start.setText(part1start);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }//onCancelled
        });

        mDatabaseRef.child("Group").child(codeNumber).child("part1_end").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                part1end = snapshot.getValue(String.class);
                part1_end.setText(part1end);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }//onCancelled
        });

        mDatabaseRef.child("Group").child(codeNumber).child("part1_edt").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                part1edt = snapshot.getValue(String.class);
                part1_edt.setText(part1edt);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }//onCancelled
        });

        mDatabaseRef.child("Group").child(codeNumber).child("part2_start").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                part2start = snapshot.getValue(String.class);
                part2_start.setText(part2start);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }//onCancelled
        });

        mDatabaseRef.child("Group").child(codeNumber).child("part2_end").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                part2end = snapshot.getValue(String.class);
                part2_end.setText(part2end);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }//onCancelled
        });

        mDatabaseRef.child("Group").child(codeNumber).child("part2_edt").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                part2edt = snapshot.getValue(String.class);
                part2_edt.setText(part2edt);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }//onCancelled
        });

        mDatabaseRef.child("Group").child(codeNumber).child("part3_start").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                part3start = snapshot.getValue(String.class);
                part3_start.setText(part3start);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }//onCancelled
        });

        mDatabaseRef.child("Group").child(codeNumber).child("part3_end").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                part3end = snapshot.getValue(String.class);
                part3_end.setText(part3end);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }//onCancelled
        });

        mDatabaseRef.child("Group").child(codeNumber).child("part3_edt").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                part3edt = snapshot.getValue(String.class);
                part3_edt.setText(part3edt);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }//onCancelled
        });
        mDatabaseRef.child("Group").child(codeNumber).child("part4_start").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                part4start = snapshot.getValue(String.class);
                part4_start.setText(part4start);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }//onCancelled
        });

        mDatabaseRef.child("Group").child(codeNumber).child("part4_end").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                part4end = snapshot.getValue(String.class);
                part4_end.setText(part4end);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }//onCancelled
        });

        mDatabaseRef.child("Group").child(codeNumber).child("part4_edt").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                part4edt = snapshot.getValue(String.class);
                part4_edt.setText(part4edt);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }//onCancelled
        });


        //저장 버튼 누르면 edittext에 썼던 내용이 실시간db에 저장됨
        Button btn_save = (Button) rootView.findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GroupData gd = new GroupData();

                mDatabaseRef.child("Group").child(codeNumber).child("part1_start").setValue(part1_start.getText().toString());
                mDatabaseRef.child("Group").child(codeNumber).child("part2_start").setValue(part2_start.getText().toString());
                mDatabaseRef.child("Group").child(codeNumber).child("part3_start").setValue(part3_start.getText().toString());
                mDatabaseRef.child("Group").child(codeNumber).child("part4_start").setValue(part4_start.getText().toString());

                mDatabaseRef.child("Group").child(codeNumber).child("part1_end").setValue(part1_end.getText().toString());
                mDatabaseRef.child("Group").child(codeNumber).child("part2_end").setValue(part2_end.getText().toString());
                mDatabaseRef.child("Group").child(codeNumber).child("part3_end").setValue(part3_end.getText().toString());
                mDatabaseRef.child("Group").child(codeNumber).child("part4_end").setValue(part4_end.getText().toString());

                mDatabaseRef.child("Group").child(codeNumber).child("part1_edt").setValue(part1_edt.getText().toString());
                mDatabaseRef.child("Group").child(codeNumber).child("part2_edt").setValue(part2_edt.getText().toString());
                mDatabaseRef.child("Group").child(codeNumber).child("part3_edt").setValue(part3_edt.getText().toString());
                mDatabaseRef.child("Group").child(codeNumber).child("part4_edt").setValue(part4_edt.getText().toString());

                activity.onFragmentChange2(0);
            }
        });

        return rootView;
    }
}