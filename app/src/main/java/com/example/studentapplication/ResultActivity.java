package com.example.studentapplication;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intentObject = getIntent();
        TextView firstName = findViewById(R.id.firstName);
        TextView lastName = findViewById(R.id.lastName);
        TextView middleInitial = findViewById(R.id.middleInitial);
        TextView gender = findViewById(R.id.gender);
        TextView apartmentName = findViewById(R.id.apartmentName);
        TextView houseNumber = findViewById(R.id.houseNumber);
        TextView lotNumber = findViewById(R.id.lotNumber);
        TextView blockNumber = findViewById(R.id.blockNumber);
        TextView street = findViewById(R.id.street);
        TextView barangay = findViewById(R.id.barangay);
        TextView cityMunicipality = findViewById(R.id.cityMunicipality);
        TextView provinceState = findViewById(R.id.provinceState);
        TextView email = findViewById(R.id.email);
        TextView contactNumber = findViewById(R.id.contactNumber);
        TextView dialectKnown = findViewById(R.id.dialectKnown);
        TextView interviewTime = findViewById(R.id.interviewTime);

        firstName.setText(intentObject.getCharSequenceExtra("firstName"));
        lastName.setText(intentObject.getCharSequenceExtra("lastName"));
        middleInitial.setText(intentObject.getCharSequenceExtra("middleInitial"));
        gender.setText(intentObject.getCharSequenceExtra("gender"));
        apartmentName.setText(intentObject.getCharSequenceExtra("apartmentName"));
        houseNumber.setText(intentObject.getCharSequenceExtra("houseNumber"));
        lotNumber.setText(intentObject.getCharSequenceExtra("lotNumber"));
        blockNumber.setText(intentObject.getCharSequenceExtra("blockNumber"));
        street.setText(intentObject.getCharSequenceExtra("street"));
        barangay.setText(intentObject.getCharSequenceExtra("barangay"));
        cityMunicipality.setText(intentObject.getCharSequenceExtra("cityMunicipality"));
        provinceState.setText(intentObject.getCharSequenceExtra("provinceState"));
        email.setText(intentObject.getCharSequenceExtra("email"));
        contactNumber.setText(intentObject.getCharSequenceExtra("contactNumber"));
        dialectKnown.setText(intentObject.getCharSequenceExtra("dialectKnown"));
        interviewTime.setText(intentObject.getCharSequenceExtra("interviewTime"));
    }
}