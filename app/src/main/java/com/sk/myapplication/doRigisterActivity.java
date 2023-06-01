package com.sk.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class doRigisterActivity extends AppCompatActivity {
    private EditText id_name,id_pwd,id_pwds;
    private ArrayList<APPUser> users = doLoginActivity.users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_rigister);
        InitView();
    }

    private void InitView() {
        id_name=findViewById(R.id.id_name);
        id_pwd=findViewById(R.id.id_pwd);
        id_pwds=findViewById(R.id.id_pwds);
    }

    public void Register(View view) {
        String name = id_name.getText().toString().trim();
        String pwd = id_pwd.getText().toString().trim();
        String pwds = id_pwds.getText().toString().trim();
        if (name.isEmpty()||pwd.isEmpty()||pwds.isEmpty()){
            Toast.makeText(this, "用户名、密码、确认密码不得为空!", Toast.LENGTH_SHORT).show();
        }else {
            if (pwd.equals(pwds)){
                Intent intent = new Intent(this,doLoginActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("pwd",pwd);
                users.add(new APPUser(name,pwd));
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(this, "您输入的密码与您输入的确认密码不一致!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void Cancel(View view) {
        finish();
    }

    public void RigisterExit(View view) {
        finish();
    }
}
