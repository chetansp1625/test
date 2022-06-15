package TACKLED.AJIET.MAD_LAB.P3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;

import TACKLED.AJIET.MAD_LAB.R;

public class P3_Signup extends AppCompatActivity  {

    EditText etSignUPUserName, etSignUPPassword;
    Button subtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p3_signup);

        etSignUPUserName = findViewById(R.id.signUpUsernameEditText);
        etSignUPPassword=findViewById(R.id.signUpPasswordEditText);
        subtn=findViewById(R.id.signUpButton);


        subtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String uname=etSignUPUserName.getText().toString();
                String pwd= etSignUPPassword.getText().toString();

                if(!pwdval(pwd))
                {
                    Toast.makeText(P3_Signup.this, "Password Does not match the rules", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(P3_Signup.this, P3_Login.class);
                    intent.putExtra("username", uname);
                    intent.putExtra("password", pwd);
                    startActivity(intent);
                }
                }
        });
    }
    Pattern lowercase = Pattern.compile("^.*[a-z].*$");
    Pattern uppercase = Pattern.compile("^.*[A-Z].*$");
    Pattern number = Pattern.compile("^.*[0-9].*$");
    Pattern specialCharacter = Pattern.compile("^.*[^a-zA-Z0-9].*$");

    private Boolean pwdval(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (!lowercase.matcher(password).matches()) {
            return false;
        }
        if (!uppercase.matcher(password).matches()) {
            return false;
        }
        if (!number.matcher(password).matches()) {
            return false;
        }
        if (!specialCharacter.matcher(password).matches()) {
            return false;
        }
        return true;
    }
}
