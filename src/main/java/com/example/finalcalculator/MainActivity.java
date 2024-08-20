package com.example.finalcalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText firstNumber, secondNumber;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views
        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        result = findViewById(R.id.result);

        // Set onClick listeners for the buttons
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });
    }

    private void calculate(char operator) {
        String num1 = firstNumber.getText().toString();
        String num2 = secondNumber.getText().toString();

        if (num1.isEmpty() || num2.isEmpty()) {
            result.setText("Please enter both numbers");
            return;
        }

        double n1 = Double.parseDouble(num1);
        double n2 = Double.parseDouble(num2);
        double res = 0;

        switch (operator) {
            case '+':
                res = n1 + n2;
                break;
            case '-':
                res = n1 - n2;
                break;
            case '*':
                res = n1 * n2;
                break;
            case '/':
                if (n2 != 0) {
                    res = n1 / n2;
                } else {
                    result.setText("Cannot divide by zero");
                    return;
                }
                break;
        }

        result.setText(String.valueOf(res));
    }
}

