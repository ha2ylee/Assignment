package org.techtown.workerholic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class Fragment01_sub extends Fragment {

    FirebaseAuth mFirebaseAuth; //파이어베이스 인증 처리
    DatabaseReference mDatabaseRef; //실시간 데이터 베이스
    GroupRoomActivity activity;
    String codeNumber;
    String notice;

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
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_fragment01_sub, container, false);

        //GroupRoomActivity로부터 값을 가져온다.
        Bundle extra = this.getArguments();
        if(extra != null) {
            extra = getArguments();
            codeNumber = extra.getString("codeNumber");

        }
        // db에 저장된 내용들 가져옴
        EditText edt = (EditText) rootView.findViewById(R.id.edit);
        mDatabaseRef.child("Group").child(codeNumber).child("notice").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                notice = snapshot.getValue(String.class);
                edt.setText(notice);

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

                mDatabaseRef.child("Group").child(codeNumber).child("notice").setValue(edt.getText().toString());
                activity.onFragmentChange(0);
            }
        });

        return rootView;
    }
}