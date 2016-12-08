package com.pouya11.phonebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.pouya11.phonebook.models.PhoneRecord;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvPhoneRecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPhoneRecord = (ListView) findViewById(R.id.lst_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        PhoneRecordAdapter phoneRecordAdapter =
                new PhoneRecordAdapter(this, PhoneRecord.select(this,null,null,null));
        lvPhoneRecord.setAdapter(phoneRecordAdapter);
    }

    public void btnChangePasswordClicked(View view) {
        startActivity(new Intent(this, ChangePasswordActivity.class));
    }

    public void btnCreateNewRecordClicked(View view) {
        startActivity(new Intent(this, CreateRecordActivity.class));
    }
}
