package com.practice.androidui;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.snackbar.Snackbar;
import java.util.Objects;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatEditText etNumOne, etNumTwo;
    AppCompatTextView result;
    AppCompatButton btnAdd, btnSub, btnMul, btnDiv;
    Snackbar snackbar;
    ConstraintLayout cLayout;
    String numVOne, numVTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);

        etNumOne = findViewById(R.id.etFNum);
        etNumTwo = findViewById(R.id.etSNum);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnSub = findViewById(R.id.btnSub);
        btnSub.setOnClickListener(this);
        btnMul = findViewById(R.id.btnMul);
        btnMul.setOnClickListener(this);
        btnDiv = findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(this);
        result = findViewById(R.id.tvDisplayResult);
        cLayout = findViewById(R.id.clCalActivity);
    }

    @Override
    public void onClick(View view) {
        numVOne = Objects.requireNonNull(etNumOne.getText()).toString().trim();
        numVTwo = Objects.requireNonNull(etNumTwo.getText()).toString().trim();

        if (numVOne.isEmpty() || numVTwo.isEmpty()){
          snackbar = Snackbar.make(cLayout, "Please Enter both numbers.", Snackbar.LENGTH_SHORT);
          snackbar.show();
          return;
        }

        double numOne = Double.parseDouble(numVOne);
        double numTwo = Double.parseDouble(numVTwo);

        if(view.getId() == R.id.btnAdd){
          result.setText(getString(R.string.result, calculate(numOne, numTwo, "+")));
        } else if (view.getId() == R.id.btnSub) {
         result.setText(getString(R.string.result, calculate(numOne, numTwo, "-")));
        } else if (view.getId() == R.id.btnMul) {
         result.setText(getString(R.string.result, calculate(numOne, numTwo, "*")));
        }else if (view.getId() == R.id.btnDiv) {
         result.setText(getString(R.string.result, calculate(numOne, numTwo, "/")));
        }
    }

    private double calculate(double a, double b, String operator){
       switch (operator){
          case "+" : return a + b;
          case "-" : return a - b;
          case "*" : return a * b;
          case "/" : return b != 0 ? a / b : 0;
          default  : return 0;
       }
    }
}