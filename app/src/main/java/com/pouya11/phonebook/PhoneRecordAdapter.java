package com.pouya11.phonebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.pouya11.phonebook.models.PhoneRecord;

import java.util.List;

/**
 * Created by Mohammad on 01/12/2016.
 */
public class PhoneRecordAdapter extends ArrayAdapter<PhoneRecord> {
    public PhoneRecordAdapter(Context context, List<PhoneRecord> objects) {
        super(context, R.layout.phone_record_view, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PhoneRecord phoneRecord = this.getItem(position);

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.phone_record_view, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tvFamily = (TextView) convertView.findViewById(R.id.tv_family);
        TextView tvPhone = (TextView) convertView.findViewById(R.id.tv_phone);
        TextView tvEmail = (TextView) convertView.findViewById(R.id.tv_email);

        tvName.setText(phoneRecord.getName());
        tvFamily.setText(phoneRecord.getFamily());
        tvPhone.setText(phoneRecord.getPhone());
        tvEmail.setText(phoneRecord.getEmail());

        return convertView;
    }
}


