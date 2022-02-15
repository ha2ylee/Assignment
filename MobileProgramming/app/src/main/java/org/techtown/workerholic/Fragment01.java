package org.techtown.workerholic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class Fragment01 extends Fragment {

    GroupRoomActivity activity;
    FirebaseAuth mFirebaseAuth; //파이어베이스 인증 처리
    DatabaseReference mDatabaseRef; //실시간 데이터 베이스
    String codeNumber, notice;

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
        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("workerholic");

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_01, container, false);
        Bundle extra = this.getArguments();
        if(extra != null) {
            extra = getArguments();
            codeNumber = extra.getString("codeNumber");
        }
        TextView tv = (TextView) rootView.findViewById(R.id.textView);
        mDatabaseRef.child("Group").child(codeNumber).child("notice").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                notice = snapshot.getValue(String.class);
                tv.setText(notice);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }//onCancelled
        });
        Button btn_write = (Button) rootView.findViewById(R.id.btn_write1);
        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onFragmentChange(1);
            }
        });
//        Button btn_check = (Button) rootView.findViewById(R.id.btn_check);
//        btn_check.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                activity.onFragmentChange(2);
//            }
//        });

        return rootView;
    }
}