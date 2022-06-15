package TACKLED.AJIET.MAD_LAB.P5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import TACKLED.AJIET.MAD_LAB.R;

public class P5_Counter extends AppCompatActivity implements View.OnClickListener {

    Button btnStart, btnStop;
    TextView tvCounterValue;

    int counter;

    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p5_counter);

        btnStart= (Button) findViewById(R.id.buttonStartCounter);
         btnStop = (Button) findViewById(R.id.buttonStopCounter);
        tvCounterValue = (TextView) findViewById(R.id.textViewCounterValue);

        counter = 0;
        handler = new Handler();
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    public void handleCounter() {
        runnable = new Runnable() {
            @Override
            public void run() {
                counter++;
                String currentNumber = String.valueOf(counter);
                tvCounterValue.setText(currentNumber);

                handler.postDelayed(this, 100);
            }
        };
        handler.post(runnable);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.buttonStartCounter:
                handleCounter();
                btnStart.setEnabled(false);
                btnStop.setEnabled(true);
                break;

            case R.id.buttonStopCounter:
                handler.removeCallbacks(runnable);
                btnStart.setEnabled(true);
                 btnStop.setEnabled(false);
                break;
        }
    }
}