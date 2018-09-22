package com.callnigeriandoc.cndpatientapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Confirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        try {
            PseudoPerson patient = (PseudoPerson) bundle.getSerializable("patientData");
            System.out.println(patient.getErrors());
        }catch(NullPointerException e){
            // TODO: Display some kind of error message
            System.out.println("There was a problem retrieving patient data");
        }

    }

    public void submit(View view){
        boolean submit_success = true;

        if(submit_success){
            Intent intent = new Intent(Confirm.this, Finish.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(Confirm.this, SubmissionError.class);
            startActivity(intent);
        }

    }
}
