package com.sk.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {
    private MainFragment mainFragment;
    private RadioGroup rgSex;
    private RadioButton rb_man,rb_woman;
    private EditText editText;
    private String name;
    private boolean sex;
    private static ArrayList<Student> students = MainFragment.students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        InitView();
    }

    private void InitView() {
        editText = findViewById(R.id.id_stuname);
        rgSex = findViewById(R.id.rg_sex);
        rb_man = findViewById(R.id.rb_man);
        rb_woman = findViewById(R.id.rb_woman);
        rgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_man){
                        sex = true;
                }else {
                    sex = false;
                }
            }
        });
    }

    private void AddData(String name,boolean sex) {
        students.add(new Student(name,!sex,false));
    }
    public void AddExit(View view) {
        Intent intent = new Intent(this,HomeActivity.class);
        intent.putExtra("Message",true);
        startActivity(intent);
        finish();
    }

    public void doAdd(View view) {
        name = editText.getText().toString();
        AddData(name,sex);
        if (name.isEmpty()){
            Toast.makeText(this, "提交失败!", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "提交成功!", Toast.LENGTH_SHORT).show();
        Init();
    }

    private void Init() {
        editText.setText("");
        rb_man.setChecked(true);
    }
}
