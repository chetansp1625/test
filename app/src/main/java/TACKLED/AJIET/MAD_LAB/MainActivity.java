package TACKLED.AJIET.MAD_LAB;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.security.spec.PKCS8EncodedKeySpec;

import TACKLED.AJIET.MAD_LAB.P1.P1_Visiting_Card;
import TACKLED.AJIET.MAD_LAB.P2.P2_Calculator;
import TACKLED.AJIET.MAD_LAB.P3.P3_Signup;
import TACKLED.AJIET.MAD_LAB.P4.P4_Wallpaper;
import TACKLED.AJIET.MAD_LAB.P5.P5_Counter;
import TACKLED.AJIET.MAD_LAB.P6.P6_parsing;
import TACKLED.AJIET.MAD_LAB.P7.P7_TextToSpeech;
import TACKLED.AJIET.MAD_LAB.P8.P8_Call_n_Save;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Visiting_card(View view) {
    Intent i = new Intent(getApplicationContext(), P1_Visiting_Card.class);
    startActivity(i);
    }

    public void Calculator(View view) {
        Intent i = new Intent(getApplicationContext(), P2_Calculator.class);
        startActivity(i);
    }
    public void Registration(View view) {
        Intent i = new Intent(getApplicationContext(), P3_Signup.class);
        startActivity(i);
    }

    public void Wallpaper(View view) {
        Intent i = new Intent(getApplicationContext(), P4_Wallpaper.class);
        startActivity(i);

    }

    public void Counter(View view) {
        Intent i = new Intent(getApplicationContext(), P5_Counter.class);
        startActivity(i);
    }

    public void Parser(View view) {
        Intent i = new Intent(getApplicationContext(), P6_parsing.class);
        startActivity(i);
    }

    public void ConvertText_to_Speech(View view) {
        Intent i = new Intent(getApplicationContext(), P7_TextToSpeech.class);
        startActivity(i);
    }

    public void call_n_save(View view) {
        Intent i = new Intent(getApplicationContext(), P8_Call_n_Save.class);
        startActivity(i);
    }
}