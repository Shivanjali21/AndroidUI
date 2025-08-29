package com.practice.androidui;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.snackbar.Snackbar;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatEditText etName,etPass;
    AppCompatButton loginBtn;
    String userName, userPass;
    ConstraintLayout cLayout;
    Snackbar snackbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = findViewById(R.id.etLoginUser);
        etPass = findViewById(R.id.etLoginPass);
        loginBtn = findViewById(R.id.loginBtn);
        cLayout = findViewById(R.id.clLoginActivity);

        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.loginBtn){
            userName = Objects.requireNonNull(etName.getText()).toString().trim();
            userPass = Objects.requireNonNull(etPass.getText()).toString().trim();

            if(userName.isEmpty() && userPass.isEmpty()){
                snackbar = Snackbar.make(cLayout, "Please fill all details", Snackbar.LENGTH_SHORT);
            } else if (userName.isEmpty()) {
               snackbar = Snackbar.make(cLayout, "Username is empty.", Snackbar.LENGTH_SHORT);
            } else if (userPass.isEmpty()) {
               snackbar = Snackbar.make(cLayout, "Password is empty.", Snackbar.LENGTH_SHORT);
            } else if (userName.equals("admin") && userPass.equals("1234")){
                snackbar = Snackbar.make(cLayout, "Login Successfully, Welcome Admin", Snackbar.LENGTH_SHORT);
                etName.setText("");
                etPass.setText("");
            }else {
                snackbar = Snackbar.make(cLayout, "Username or Password is invalid!!", Snackbar.LENGTH_SHORT);
            }
            snackbar.show();
        }
    }
}
