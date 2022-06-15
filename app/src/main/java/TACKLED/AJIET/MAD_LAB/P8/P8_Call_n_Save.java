package TACKLED.AJIET.MAD_LAB.P8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import TACKLED.AJIET.MAD_LAB.R;

public class P8_Call_n_Save extends AppCompatActivity {

    EditText etNuminp;
    Button btnClear, btnCall, btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p8_call_nsave);

        etNuminp = findViewById((R.id.editTextPhoneNumber));
        btnCall = findViewById(R.id.buttonCall);
        btnSave = findViewById(R.id.buttonSave);

        btnClear = findViewById(R.id.buttonClear);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNuminp.setText("");
            }
        });

        btnCall.setOnClickListener(v -> {

            String phno = etNuminp.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phno));
            P8_Call_n_Save.this.startActivity(intent);
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phno = etNuminp.getText().toString();
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.PHONE, phno);
                startActivity(intent);
            }
        });
    }
}