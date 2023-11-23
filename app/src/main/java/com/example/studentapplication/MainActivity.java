package com.example.studentapplication;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intentObject = new Intent(MainActivity.this, ResultActivity.class);
        final EditText LAST_NAME = findViewById(R.id.lastName);
        final EditText FIRST_NAME = findViewById(R.id.firstName);
        final EditText MIDDLE_INITIAL = findViewById(R.id.middleInitial);
        final EditText CONTACT_NUMBER = findViewById(R.id.contactNumber);
        final EditText STREET = findViewById(R.id.street);
        final EditText LOT_NUMBER = findViewById(R.id.lotNumber);
        final EditText HOUSE_NUMBER = findViewById(R.id.houseNumber);
        final EditText APARTMENT_NAME = findViewById(R.id.apartmentName);
        final EditText BARANGAY = findViewById(R.id.barangay);
        final EditText CITY_MUNICIPALITY = findViewById(R.id.cityMunicipality);
        final EditText BLOCK_NUMBER = findViewById(R.id.blockNumber);
        final EditText PROVINCE_STATE = findViewById(R.id.provinceState);
        final EditText EMAIL = findViewById(R.id.email);
        final TextView SET_TIME_TEXTVIEW = findViewById(R.id.setTimeTextView);
        final RadioGroup GENDER_GROUP = findViewById(R.id.genderGroup);
        final Spinner DIALECT_KNOWN = findViewById(R.id.dialectKnown);
        final Button SET_TIME = findViewById(R.id.setTime);
        final ImageButton SUBMIT = findViewById(R.id.submit);

        SET_TIME.setOnClickListener(new View.OnClickListener() {
            final Calendar calendarObject = Calendar.getInstance();
            final int currentMinute = calendarObject.get(Calendar.MINUTE);
            final int currentHour = calendarObject.get(Calendar.HOUR_OF_DAY);

            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, (view, hour, minute) -> {
                    final String interviewTime;
                    if (minute < 10) {
                        interviewTime = hour + " : 0" + minute;
                    } else {
                        interviewTime = hour + " : " + minute;
                    }
                    SET_TIME_TEXTVIEW.setText(interviewTime);

                }, currentHour, currentMinute, false);
                timePickerDialog.show();

            }
        });

        SUBMIT.setOnClickListener(v -> {
            if (FIRST_NAME.getText().toString().equals("")) {
                Toast.makeText(this, "First Name can't be empty", Toast.LENGTH_SHORT).show();
            } else if (LAST_NAME.getText().toString().equals("")) {
                Toast.makeText(this, "Last Name can't be empty", Toast.LENGTH_SHORT).show();
            } else if (MIDDLE_INITIAL.getText().toString().equals("")) {
                Toast.makeText(this, "Middle Initial can't be empty", Toast.LENGTH_SHORT).show();
            } else if (CONTACT_NUMBER.getText().toString().equals("")) {
                Toast.makeText(this, "Contact Number can't be empty", Toast.LENGTH_SHORT).show();
            } else if (STREET.getText().toString().equals("")) {
                Toast.makeText(this, "Street can't be empty", Toast.LENGTH_SHORT).show();
            } else if (LOT_NUMBER.getText().toString().equals("")) {
                Toast.makeText(this, "Lot Number can't be empty", Toast.LENGTH_SHORT).show();
            } else if (HOUSE_NUMBER.getText().toString().equals("")) {
                Toast.makeText(this, "House Number can't be empty", Toast.LENGTH_SHORT).show();
            } else if (APARTMENT_NAME.getText().toString().equals("")) {
                Toast.makeText(this, "Apartment Name can't be empty", Toast.LENGTH_SHORT).show();
            } else if (BARANGAY.getText().toString().equals("")) {
                Toast.makeText(this, "Barangay can't be empty", Toast.LENGTH_SHORT).show();
            } else if (CITY_MUNICIPALITY.getText().toString().equals("")) {
                Toast.makeText(this, "City Municipality can't be empty", Toast.LENGTH_SHORT).show();
            } else if (BLOCK_NUMBER.getText().toString().equals("")) {
                Toast.makeText(this, "Block Number can't be empty", Toast.LENGTH_SHORT).show();
            } else if (PROVINCE_STATE.getText().toString().equals("")) {
                Toast.makeText(this, "Province/State can't be empty", Toast.LENGTH_SHORT).show();
            } else if (EMAIL.getText().toString().equals("")) {
                Toast.makeText(this, "Email can't be empty", Toast.LENGTH_SHORT).show();
            } else if (SET_TIME_TEXTVIEW.getText().toString().equals("--:--")) {
                Toast.makeText(this, "Interview Time can't be empty", Toast.LENGTH_SHORT).show();
            } else if (GENDER_GROUP.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Gender can't be empty", Toast.LENGTH_SHORT).show();
            } else {
                int radioID = GENDER_GROUP.getCheckedRadioButtonId();

                intentObject.putExtra("firstName", "First Name: " + FIRST_NAME.getText().toString());
                intentObject.putExtra("middleInitial", "Middle Initial: " + MIDDLE_INITIAL.getText().toString());
                intentObject.putExtra("lastName", "Last Name: " + LAST_NAME.getText().toString());
                intentObject.putExtra("contactNumber", "Contact Number: " + CONTACT_NUMBER.getText().toString());
                intentObject.putExtra("street", "Street: " + STREET.getText().toString());
                intentObject.putExtra("lotNumber", "Lot Number: " + LOT_NUMBER.getText().toString());
                intentObject.putExtra("houseNumber", "House Number: " + HOUSE_NUMBER.getText().toString());
                intentObject.putExtra("apartmentName", "Apartment Name: " + APARTMENT_NAME.getText().toString());
                intentObject.putExtra("barangay", "Barangay: " + BARANGAY.getText().toString());
                intentObject.putExtra("cityMunicipality", "City/Municipality: " + CITY_MUNICIPALITY.getText().toString());
                intentObject.putExtra("blockNumber", "Block Number: " + BLOCK_NUMBER.getText().toString());
                intentObject.putExtra("provinceState", "Province/State: " + PROVINCE_STATE.getText().toString());
                intentObject.putExtra("email", "Email: " + EMAIL.getText().toString());
                intentObject.putExtra("interviewTime", "Interview Time: " + SET_TIME_TEXTVIEW.getText().toString());
                intentObject.putExtra("gender", "Gender: " + ((RadioButton) findViewById(radioID)).getText().toString());
                intentObject.putExtra("dialectKnown", "Dialect Known: " + DIALECT_KNOWN.getSelectedItem().toString());
                startActivity(intentObject);
            }
        });


    }
}