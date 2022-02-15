package org.techtown.workerholic;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;

public class Fragment03_main extends Fragment {

    FirebaseAuth mFirebaseAuth; //파이어베이스 인증 처리
    DatabaseReference mDatabaseRef; //실시간 데이터 베이스
    GroupRoomActivity activity;
    String codeNumber;
    EditText[] edit_name = new EditText[8];
    String[] worker_name = new String[8];
    String[] name = new String[8];
    String[] name_storage = new String[8];

    Callback callback = new Callback() {
        @Override
        public void success(String[] data) {
            name_storage = data;
        }

        @Override
        public void fail(String errorMessage) {

        }
    };

    String snap;



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
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_fragment03_main, container, false);




        //GroupRoomActivity로부터 값을 가져온다.
        Bundle extra = this.getArguments();
        if(extra != null) {
            extra = getArguments();
            codeNumber = extra.getString("codeNumber");

        }
        // 우선, db에 저장된 내용들 가져옴
        Integer[] Rid_Edit = {
                R.id.worker1_name, R.id.worker2_name, R.id.worker3_name, R.id.worker4_name,R.id.worker5_name,
                R.id.worker6_name, R.id.worker7_name, R.id.worker8_name

        };
        for(int i =0; i<Rid_Edit.length;i++){
            edit_name[i]= (EditText) rootView.findViewById(Rid_Edit[i]);
        }

        for(int i=0; i<Rid_Edit.length; i++){
            worker_name[i] ="name"+i;

        }
        for(int i=0; i<Rid_Edit.length; i++){
            worker_name[i] ="name"+i;

        }

        mDatabaseRef.child("GroupMember").child(codeNumber).child(worker_name[0]).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                    snap= snapshot.getValue(String.class);
                    edit_name[0].setText(snap);
                }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("GroupMember").child(codeNumber).child(worker_name[1]).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                snap= snapshot.getValue(String.class);
                edit_name[1].setText(snap);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("GroupMember").child(codeNumber).child(worker_name[2]).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                snap= snapshot.getValue(String.class);
                edit_name[2].setText(snap);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("GroupMember").child(codeNumber).child(worker_name[3]).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                snap= snapshot.getValue(String.class);
                edit_name[3].setText(snap);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("GroupMember").child(codeNumber).child(worker_name[4]).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                snap= snapshot.getValue(String.class);
                edit_name[4].setText(snap);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("GroupMember").child(codeNumber).child(worker_name[5]).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                snap= snapshot.getValue(String.class);
                edit_name[5].setText(snap);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("GroupMember").child(codeNumber).child(worker_name[6]).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                snap= snapshot.getValue(String.class);
                edit_name[6].setText(snap);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });
        mDatabaseRef.child("GroupMember").child(codeNumber).child(worker_name[7]).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                snap= snapshot.getValue(String.class);
                edit_name[7].setText(snap);
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

                for(int i=0;i<Rid_Edit.length; i++){
                    name[i] = edit_name[i].getText().toString();
                    mDatabaseRef.child("GroupMember").child(codeNumber).child(worker_name[i]).setValue(name[i]);
                    Toast.makeText(getActivity(), "저장되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Bundle bundle = new Bundle();

        bundle.putString("name0",name_storage[0]);
        bundle.putString("codeNumber",codeNumber);


        Fragment03_1 fragment03_1 = new Fragment03_1();
        Button worker1_btn = (Button) rootView.findViewById(R.id.worker1_btn);
        worker1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onFragmentChange3to1(1);

                fragment03_1.setArguments(bundle);
            }
        });



        return rootView;
    }
}