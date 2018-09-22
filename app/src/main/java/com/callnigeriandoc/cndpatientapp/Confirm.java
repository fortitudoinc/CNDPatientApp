package com.callnigeriandoc.cndpatientapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Confirm extends AppCompatActivity {
    PseudoPerson patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        patient = null;

        try {
            patient = (PseudoPerson) bundle.getSerializable("patientData");
        }catch(NullPointerException e){
            // TODO: Display some kind of error message
            System.out.println("There was a problem retrieving patient data");
        }

        TextView firstNameTextView = findViewById(R.id.confirmFirstNameValue);
        firstNameTextView.setText(patient.getFirstName());

        TextView lastNameTextview = findViewById(R.id.confirmLastNameValue);
        lastNameTextview.setText(patient.getLastName());

        TextView phoneNumberTextView = findViewById(R.id.confirmPhoneNumberValue);
        phoneNumberTextView.setText(patient.getPhoneNumber());

        TextView genderTextView = findViewById(R.id.confirmGenderValue);
        genderTextView.setText(patient.getGender());

    }

    public void submit(View view){
        patient.pushToOpenMRS();

        // TODO: Get any errors from API
        boolean submit_success = true;

        if(submit_success){
            Intent intent = new Intent(Confirm.this, Finish.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(Confirm.this, SubmissionError.class);
            startActivity(intent);
        }

    }

    public void goBack(View view){
        finish();
    }
}
