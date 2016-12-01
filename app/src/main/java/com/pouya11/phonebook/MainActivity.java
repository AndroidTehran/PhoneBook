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

        lvPhoneRecord = (ListView) findViewById(R.id.listView);

        ArrayList<PhoneRecord> dummy_list = new ArrayList<>();
        dummy_list.add(new PhoneRecord("Ali", "Valizade", "09129994444", "email@domain.com"));
        dummy_list.add(new PhoneRecord("Sara", "Valizade", "09129994442", "email2@domain.com"));
        dummy_list.add(new PhoneRecord("Joe", "Japani", "001-888-8761342", "email@dsaweq.us"));
        dummy_list.add(new PhoneRecord("Jack", "Sparrow", "---", "---"));

        PhoneRecordAdapter phoneRecordAdapter = new PhoneRecordAdapter(this, dummy_list);
        lvPhoneRecord.setAdapter(phoneRecordAdapter);
    }

    public void btnChangePasswordClicked(View view) {
        startActivity(new Intent(this, ChangePasswordActivity.class));
    }
}
