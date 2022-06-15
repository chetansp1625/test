package TACKLED.AJIET.MAD_LAB.P3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import TACKLED.AJIET.MAD_LAB.R;

public class P3_Login extends AppCompatActivity {
    EditText etLoginUserName, etLoginPassword;
    Button lobtn;
    int i=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p3_login);

        etLoginUserName=findViewById(R.id.loginInUsernameEditText);
        etLoginPassword=findViewById(R.id.logInPasswordEditText);
        lobtn=findViewById(R.id.logInButton);

        String regUname=getIntent().getStringExtra("username");
        String regPass=getIntent().getStringExtra("password");



        lobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname=etLoginUserName.getText().toString();
                String upass=etLoginPassword.getText().toString();

                if (regUname.equals(uname) && regPass.equals(upass))
                {
                    Intent intent=new Intent(P3_Login.this,P3_Login_Success.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(P3_Login.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                }
                i--;
                if(i==0)
                {
                    Toast.makeText(getBaseContext(),"FAILED LOGIN ATTEMPTS",Toast.LENGTH_LONG).show();
                    lobtn.setEnabled(false);
                }
            }
        });
    }
}
