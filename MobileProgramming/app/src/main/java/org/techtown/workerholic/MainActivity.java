package org.techtown.workerholic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    public static String groupName;
    private AlertDialog dialog;
    private EditText codeNum;
    public boolean flag=false;
    private Button btn_entry, btn_makeGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater inflater = getLayoutInflater();

        //alertdialog 불러옴
        final View v = inflater.inflate(R.layout.dialog_layout, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(v);
        dialog = builder.create();
        dialog.show();
        dialog.setCancelable(false);


        codeNum = (EditText) v.findViewById(R.id.codeNum);
        btn_entry = (Button) v.findViewById(R.id.btn_entry);
        btn_makeGroup = (Button) v.findViewById(R.id.btn_makeGroup);


    }

    public void onEntryButtonClicked(View view) {
        String code = codeNum.getText().toString();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getInstance().getReference("workerholic");

        myRef.child("Group").child(code).child("codeNumber").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //값이 있으면 flag true, 없으면 false..
                if(snapshot.getValue(String.class)!=null){
                    Intent intent = new Intent(getApplicationContext(), GroupRoomActivity.class);
                    intent.putExtra("codeNumber", code);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), code + "에 입장하셨습니다.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "일치하는 코드번호가 없습니다.", Toast.LENGTH_SHORT).show();
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }//onCancelled
        });


    }


    public void onGroupButtonClicked(View view) {

        Intent intent = new Intent(getApplicationContext(), MakeGroupActivity.class);
        startActivity(intent);
        Toast.makeText(this, "새로운 그룹을 생성합니다.", Toast.LENGTH_SHORT).show();
    }
}