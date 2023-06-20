package com.example.time_planner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.database.entitas.User;

public class activity_aad extends AppCompatActivity {
    private EditText editTitle, editDesc, editDate, editTime, editEven;
    private Button btnSave;
    private AppDatabase database;
    private int uid = 0;
    private boolean isEdit = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aad);
        editTitle = findViewById(R.id.title);
        editDesc = findViewById(R.id.desc);
        editDate = findViewById(R.id.date);
        editTime = findViewById(R.id.time);
        editEven = findViewById(R.id.even);
        btnSave = findViewById(R.id.btn_save);

        database = AppDatabase.getInstance(getApplicationContext());

        Intent intent = getIntent();
        uid = intent.getIntExtra("uid", 0);
        if (uid>0){
            isEdit = true;
            User user = database.userDao().get(uid);
            editTitle.setText(user.title);
            editDesc.setText(user.desc);
            editDate.setText(user.date);
            editTime.setText(user.time);
            editEven.setText(user.even);
        }else{
            isEdit = false;
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEdit){
                    database.userDao().update(editTitle.getText().toString(), editDesc.getText().toString(), editDate.getText().toString(), editTime.getText().toString(), editEven.getText().toString());
                }else {
                    database.userDao().insertAll(editTitle.getText().toString(), editDesc.getText().toString(), editDate.getText().toString(), editTime.getText().toString(), editEven.getText().toString());
                }
                finish();
            }
        });
    }
    }
