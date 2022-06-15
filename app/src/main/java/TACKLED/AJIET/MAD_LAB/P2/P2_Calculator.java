package TACKLED.AJIET.MAD_LAB.P2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import TACKLED.AJIET.MAD_LAB.R;

public class P2_Calculator extends AppCompatActivity {
        EditText e1, e2;
        TextView t1;
        int num1, num2;
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_p2_calculator);
        }

        public boolean getNumbers()
        {
            e1 = (EditText)findViewById(R.id.num1);
            e2 = (EditText)findViewById(R.id.num2);
            t1 = (TextView)findViewById(R.id.result);
            String s1 = e1.getText().toString();
            String s2 = e2.getText().toString();

            // condition to check if box is not empty
            if ((s1.equals(null) && s2.equals(null))
                    || (s1.equals("") && s2.equals(""))) {
                String result = "Please enter a value";
                t1.setText(result);
                return false;
            }
            else {
                // converting string to int.
                num1 = Integer.parseInt(e1.getText().toString());
                num2 = Integer.parseInt(e2.getText().toString());
            }
            return true;
        }
        // a public method to perform addition
        public void doSum(View v)
        {
            // get the input numbers
            if (getNumbers()) {
                int sum = num1 + num2;
                t1.setText(Integer.toString(sum));
            }
        }
        // a public method to perform power function
        public void doPow(View v)
        {
            // get the input numbers
            if (getNumbers()) {
                double sum = Math.pow(num1, num2);
                t1.setText(Double.toString(sum));
            }
        }
        // a public method to perform subtraction
        public void doSub(View v)
        {
            // get the input numbers
            if (getNumbers()) {
                int sum = num1 - num2;
                t1.setText(Integer.toString(sum));
            }
        }
        // a public method to perform multiplication
        public void doMul(View v)
        {
            // get the input numbers
            if (getNumbers()) {
                int sum = num1 * num2;
                t1.setText(Integer.toString(sum));
            }
        }
        // a public method to perform Division
        public void doDiv(View v)
        {
            // get the input numbers
            if (getNumbers()) {
                // displaying the text in text view assigned as t1
                double sum = num1 / (num2 * 1.0);
                t1.setText(Double.toString(sum));
            }
        }
        // a public method to perform modulus function
        public void doMod(View v)
        {
            // get the input numbers
            if (getNumbers()) {
                double sum = num1 % num2;
                t1.setText(Double.toString(sum));
            }
        }
    }