package forbridge.sselab.com.bridgemonitor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 2017/10/9.
 */

public class LoginActivity extends Activity{
    private Button loginBtn;
    private EditText username;
    private EditText password;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        username = (EditText) findViewById(R.id.usernameEtext);
        password = (EditText) findViewById(R.id.passWordEtext);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getaccount=username.getText().toString();
                String getpassword=password.getText().toString();
                if(getaccount.equals("1")&&getpassword.equals("1")) {
                    Intent intent = new Intent(LoginActivity.this, allTaskActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
