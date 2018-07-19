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
    }

    public void goToSymptoms(View view){
        Intent intent = new Intent(Confirm.this, Symptoms.class);
        startActivity(intent);
    }

    public void goToFinish(View view){
        Intent intent = new Intent(Confirm.this, Finish.class);
        startActivity(intent);
    }
}
