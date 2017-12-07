package cn.itcast.userregist;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText et_password;
    private Button btn_login;
    private EditText et_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_name = (EditText) findViewById(R.id.et_lname);
        et_password = (EditText) findViewById(R.id.et_lpassword);
        btn_login = (Button) findViewById(R.id.btn_lsend);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            UserDao  userDao= new UserDao(LoginActivity.this);
            String name=et_name.getText().toString().trim();
            String pwd = et_password.getText().toString().trim();
            UserInfo userInfo= userDao.query(name,pwd);
            if(userInfo==null) //用户不存在
            {
                //Toast.makeText(LoginActivity.this, "用户："+name+" 不存在或者密码不正确！", Toast.LENGTH_SHORT).show();
                NomalDialog("用户："+name+" 不存在或者密码不正确！");
            }else {
                Intent intent = new Intent(LoginActivity.this, ShowActivity.class);
                //将数据存入Intent对象
                intent.putExtra("name", userInfo.getName());
                intent.putExtra("password", userInfo.getPassword());
                startActivity(intent);
            }
            }
        });
    }

    private void NomalDialog(String msg) {
        //普通对话框
        AlertDialog dialog;                           //声明对象
        dialog = new AlertDialog.Builder(this)        //绑定当前界面窗口
                .setTitle("提示")             //设置标题
                .setMessage(msg)         //设置提示信息
                .setIcon(R.mipmap.ic_launcher)       //设置图标
                .setPositiveButton("确定",null )     //添加“确定”按钮
                .setNegativeButton("取消", null)     //添加“取消”按钮
                .create();                          //创建对话框
        dialog.show();                              //显示对话框
    }

    public void onRegister(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
