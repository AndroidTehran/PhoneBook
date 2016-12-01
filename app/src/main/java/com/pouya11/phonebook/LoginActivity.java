package com.pouya11.phonebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtPassword = (EditText) findViewById(R.id.txt_password);
    }

    public void btnLoginClicked(View view) {
        if(txtPassword.getText().toString().equals("123456")){
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
