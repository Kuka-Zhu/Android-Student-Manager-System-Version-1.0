package com.sk.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class doLoginActivity extends AppCompatActivity {
    private EditText id_name,id_pwd;
    private CheckBox cb_pwd;
    private SharedPreferences remember;
    private SharedPreferences.Editor editor;
    private ImageButton id_imagebutton;
    public static ArrayList<APPUser> users = new ArrayList<>();
    public static int UserID;
    static {
        users.add(new APPUser("zhushang","123456"));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_login);
        InitView();
        Reload();
    }
    private void InitData() {
        if (getIntent()!=null){
            Intent intent = getIntent();
            String name = intent.getStringExtra("name");
            String pwd = intent.getStringExtra("pwd");
            users.add(new APPUser(name,pwd));
            id_name.setText(name);
            id_pwd.setText(pwd);
        }
    }
    private void Reload() {
        String name = remember.getString("name", "");
        String pwd = remember.getString("pwd", "");
        boolean pwds = remember.getBoolean("cb_pwd", false);
        if (pwds){
            id_name.setText(name);
            id_pwd.setText(pwd);
            cb_pwd.setChecked(true);
        }else {
            InitData();
        }
    }

    private void InitView() {
        id_name=findViewById(R.id.id_name);
        id_pwd=findViewById(R.id.id_pwd);
        cb_pwd=findViewById(R.id.cb_pwd);
        remember = getSharedPreferences("share_login", MODE_PRIVATE);
        id_imagebutton = findViewById(R.id.id_imagebutton);
        id_imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void doLogin(View view) {
        String name = id_name.getText().toString().trim();
        String pwd = id_pwd.getText().toString().trim();
        if (name.isEmpty()||pwd.isEmpty()){
            Toast.makeText(this, "用户名或密码不得为空!", Toast.LENGTH_SHORT).show();
        }else {
            if (CheckUser(name,pwd)){
                Toast.makeText(this, "登录成功!", Toast.LENGTH_SHORT).show();
                if (cb_pwd.isChecked()){
                    editor=remember.edit();
                    editor.putString("name",name);
                    editor.putString("pwd",pwd);
                    editor.putBoolean("cb_pwd",cb_pwd.isChecked());
                    editor.commit();
                }
                Intent intent =new Intent(doLoginActivity.this,HomeActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "用户名或密码错误!", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }
    public boolean CheckUser(String name,String pwd){
        for (int i = 0; i < users.size(); i++) {
            if (name.equals(users.get(i).getUsername())){
                if (pwd.equals(users.get(i).getPwd())){
                    UserID = i;
                    return true;
                }
                continue;
            }
            continue;
        }
        return false;
    }

    public void doRigister(View view) {
        Intent intent = new Intent(this,doRigisterActivity.class);
        startActivity(intent);
    }

    public void Exit(View view) {
        finish();
    }
}
