package com.kun.fileoperation;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText et_username;
    private EditText et_password;
    private CheckBox cp;

    private static String PWD = "123456";
    private static String USERNAME = "pyk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        cp = (CheckBox) findViewById(R.id.cp);

        String user = SaveFileService.findUser(this);
        if (user != null) {
            String[] split = user.split(":");
            et_username.setText(split[0]);
            et_password.setText(split[1]);
        }
    }

    public void login(View view) {
        String username = et_username.getText().toString();
        String pwd = et_password.getText().toString();
        boolean isChecked = cp.isChecked();

        //判断用户名是否为空
        if(TextUtils.isEmpty(username)){
            Toast.makeText(this,"用户名不能为空！",Toast.LENGTH_SHORT).show();
            return;
        }

        //判断密码是否为空
        if(TextUtils.isEmpty(pwd)){
            Toast.makeText(this,"密码不能为空！",Toast.LENGTH_SHORT).show();
            return;
        }

        if (!USERNAME.equals(username)&&!PWD.equals(pwd)) {
            if (isChecked) {
                Log.i(">>>>",this.getFilesDir().toString());
                SaveFileService.saveFile(this, username, pwd);
            } else {
                SaveFileService.deleteFile(this);
            }
            Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "登录失败！", Toast.LENGTH_SHORT).show();
        }

    }
}
