package com.sk.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {
    private EditText id_old_pwd,id_new_pwd,id_qrmm;
    private Button id_submit;
    private ArrayList<APPUser> users = doLoginActivity.users;
    private int userID = doLoginActivity.UserID;
    private TextView id_username_setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        InitView();
    }

    private void InitView() {
        id_old_pwd = findViewById(R.id.id_old_pwd);
        id_new_pwd = findViewById(R.id.id_new_pwd);
        id_qrmm = findViewById(R.id.id_qrmm);
        id_submit = findViewById(R.id.id_submit);
        id_username_setting = findViewById(R.id.id_username_setting);
        id_username_setting.setText(users.get(userID).getUsername());
    }

    public void Submit(View view) {
        String old = id_old_pwd.getText().toString();
        String npwd = id_new_pwd.getText().toString();
        String qrmm = id_qrmm.getText().toString();
        if (old.isEmpty()||npwd.isEmpty()||qrmm.isEmpty()){
            Toast.makeText(this, "旧密码、新密码或确认密码不得为空!", Toast.LENGTH_SHORT).show();
            return;
        }else {
            if (!old.equals(users.get(userID).getPwd())){
                Toast.makeText(this, "旧密码错误，请修改后重试!", Toast.LENGTH_SHORT).show();
                return;
            }else {
                if (old.equals(npwd)){
                    Toast.makeText(this, "新密码与旧密码相同，请修改后重试!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!npwd.equals(qrmm)){
                    Toast.makeText(this, "确认密码与新密码不一致，请修改后重试!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            APPUser appUser = users.get(userID);
            appUser.setPwd(qrmm);
            finish();
        }
    }

    public void SettingExit(View view) {
        finish();
    }
}
