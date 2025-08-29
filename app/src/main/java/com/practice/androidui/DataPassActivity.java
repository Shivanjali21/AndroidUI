package com.practice.androidui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.snackbar.Snackbar;
import java.util.Objects;

public class DataPassActivity extends AppCompatActivity implements View.OnClickListener{

    AppCompatEditText etName, etAge;
    AppCompatButton btnPassData;
    Snackbar snackbar;
    ConstraintLayout cLayout;
    String name, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pass);

        etName = findViewById(R.id.etUserName);
        etAge = findViewById(R.id.etUserAge);
        btnPassData = findViewById(R.id.btnPassData);
        cLayout = findViewById(R.id.clDataPass);

        //btnPassData.setEnabled(false); // Disabled by default
        btnPassData.setTextColor(ContextCompat.getColor(this, R.color.color_grey));
        btnPassData.setBackgroundColor(ContextCompat.getColor(this, R.color.color_zambezi));

        btnPassData.setOnClickListener(this);
        textInputWatcher();
    }

    private void textInputWatcher() {
        TextWatcher inputWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                name = inputEditText(etName);
                age = inputEditText(etAge);
                boolean isDataFilled = !name.isEmpty() && !age.isEmpty();
                btnPassData.setEnabled(isDataFilled);

                if(isDataFilled){
                    btnPassData.setTextColor(ContextCompat.getColor(DataPassActivity.this, R.color.color_white));
                    btnPassData.setBackgroundDrawable(ContextCompat.getDrawable(DataPassActivity.this, R.drawable.curve_btn));
                }else {
                    btnPassData.setTextColor(ContextCompat.getColor(DataPassActivity.this, R.color.color_grey));
                    btnPassData.setBackgroundColor(ContextCompat.getColor(DataPassActivity.this, R.color.color_zambezi));
                }
            }
        };

        etName.addTextChangedListener(inputWatcher);
        etAge.addTextChangedListener(inputWatcher);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnPassData){
            name = inputEditText(etName);
            age = inputEditText(etAge);

            if(name.isEmpty() || age.isEmpty()){
              snackbar = Snackbar.make(cLayout, getString(R.string.all_fields), Snackbar.LENGTH_SHORT);
              snackbar.show();
              return;
            }

            if(!validAge(age)){
                snackbar = Snackbar.make(cLayout, getString(R.string.valid_age), Snackbar.LENGTH_SHORT);
                snackbar.show();
            }else {
                Intent intent =  new Intent(this, DataReceiveActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("age", Integer.parseInt(age));
                startActivity(intent);
                finish();
            }
        }
    }

    private String inputEditText(AppCompatEditText editText){
      return Objects.requireNonNull(editText.getText()).toString().trim();
    }
    private boolean validAge(String age){
        try {
           int userAge = Integer.parseInt(age);
           return userAge != 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}