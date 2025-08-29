package com.practice.androidui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.snackbar.Snackbar;

public class DataReceiveActivity extends AppCompatActivity {

    AppCompatTextView name, age;
    String receiveName, message;
    Integer receiveAge;
    Snackbar snackbar;
    ConstraintLayout cLayout;
    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_data_receive);

      receiveName = getIntent().getStringExtra("name");
      receiveAge = getIntent().getIntExtra("age", 0);
      name = findViewById(R.id.tvDisplayName);
      age = findViewById(R.id.tvDisplayAge);
      cLayout = findViewById(R.id.clDataReceive);

      name.setText(getString(R.string.your_name, receiveName));
      age.setText(getString(R.string.your_age, receiveAge));

      if(receiveAge >= 18){
       message = String.format(getString(R.string.vote), receiveName);
       color = ContextCompat.getColor(this, R.color.color_green);
      }else {
       message = String.format(getString(R.string.no_vote), receiveName);
       color = ContextCompat.getColor(this, R.color.color_red);
      }
      name.setTextColor(color);
      age.setTextColor(color);
      snackbar = Snackbar.make(cLayout, message, Snackbar.LENGTH_SHORT);
      snackbar.getView().setBackgroundColor(color);
      snackbar.show();
    }
}