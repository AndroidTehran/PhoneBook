package com.pouya11.phonebook;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pouya11.phonebook.models.PhoneRecord;

public class CreateRecordActivity extends AppCompatActivity {

    EditText txtName;
    EditText txtFamily;
    EditText txtPhone;
    EditText txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_record);

        txtName = (EditText) findViewById(R.id.txt_name);
        txtFamily = (EditText) findViewById(R.id.txt_family);
        txtPhone = (EditText) findViewById(R.id.txt_phone);
        txtEmail = (EditText) findViewById(R.id.txt_email);
    }

    public void btnCancelClicked(View view) {
        finish();
    }

    public void btnSaveClicked(View view) {
        String name = txtName.getText().toString();
        String family = txtFamily.getText().toString();
        String phone = txtPhone.getText().toString();
        String email = txtEmail.getText().toString();

        PhoneRecord phoneRecord = new PhoneRecord(name, family, phone, email);

        if(phoneRecord.save(this)){
            Toast.makeText(this, "Saved successfully", Toast.LENGTH_LONG).show();
            finish();
        }else{
            Toast.makeText(this, "Oops!! something went wrong", Toast.LENGTH_LONG).show();

            Vibrator v = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
            v.vibrate(500);
        }
    }
}
