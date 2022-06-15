package TACKLED.AJIET.MAD_LAB.P7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

import TACKLED.AJIET.MAD_LAB.R;

public class P7_TextToSpeech extends AppCompatActivity implements View.OnClickListener {

    EditText etInput;
    Button btnConvert;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p7_text_to_speech);

        etInput = (EditText) findViewById(R.id.editTextInput);
        btnConvert = (Button) findViewById(R.id.buttonConvert);

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });

        btnConvert.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String string = etInput.getText().toString();
        if (string.equals(""))
             makeToast("Enter text to Listen!!!");
        else {
            makeToast(string);
        textToSpeech.speak(string,TextToSpeech.QUEUE_FLUSH,null);
        }
    }

    private void makeToast(String toastMessage) {
        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
    }
}