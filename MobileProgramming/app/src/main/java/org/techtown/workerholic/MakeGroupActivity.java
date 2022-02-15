package org.techtown.workerholic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class MakeGroupActivity extends AppCompatActivity {
    Button btn_makeGroup;
    FirebaseAuth mFirebaseAuth; //파이어베이스 인증 처리
    DatabaseReference mDatabaseRef; //실시간 데이터 베이스
    EditText groupName, codeNum; //입력필드
    static boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_group);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("workerholic");

        btn_makeGroup = (Button)findViewById(R.id.btn_makeGroup);
        groupName =(EditText)findViewById(R.id.groupName);
        codeNum =(EditText)findViewById(R.id.codeNum);


        btn_makeGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = codeNum.getText().toString();
                String name = groupName.getText().toString();
                mDatabaseRef.child("Group").child(code).child("codeNumber").
                        addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //해당하는 값이 있다면
                        if(snapshot.getValue(String.class)!=null){


                            //FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "그룹코드를 다시 입력해주세요.",
                                    Toast.LENGTH_SHORT).show();

                        //없으면 그룹생성
                        }else{
                            GroupData groupData = new GroupData(name,code);

                            mDatabaseRef.child("Group").child(code).setValue(groupData);
                            Toast.makeText(getApplicationContext(), "그룹을 생성했습니다.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);


                        }

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }//onCancelled
                });


            }

        });
    }
}
