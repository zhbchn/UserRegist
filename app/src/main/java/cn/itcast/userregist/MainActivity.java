package cn.itcast.userregist;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    private EditText et_password;
    private Button btn_send;
    private EditText et_name;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_send = (Button) findViewById(R.id.btn_send);
        //点击开始游戏按钮进行数据传递
        btn_send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                passData();
            }
        });
    }
    //传递数据
    public void passData() {
        //创建Intent对象,启动Activity02
//        Intent intent = new Intent(this, ShowActivity.class);
//        //将数据存入Intent对象
//        intent.putExtra("name", et_name.getText().toString().trim());
//        intent.putExtra("password", et_password.getText().toString().trim());
//        startActivity(intent);
        UserDao userdao= new UserDao(this);
        UserInfo user = new UserInfo();
        user.setName(et_name.getText().toString().trim());
        user.setPassword(et_password.getText().toString().trim());
        userdao.insertUser(user);
        NomalDialog(user.getName()+"注册成功，请返回登录界面登录！");
        finish();
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


}
