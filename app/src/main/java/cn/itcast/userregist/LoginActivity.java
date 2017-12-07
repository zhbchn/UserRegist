package cn.itcast.userregist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

          Intent intent = new Intent(LoginActivity.this,ShowActivity.class);
          //将数据存入Intent对象
          intent.putExtra("name", et_name.getText().toString().trim());
          intent.putExtra("password", et_password.getText().toString().trim());
          startActivity(intent);
            }
        });
    }
}
