package com.callnigeriandoc.cndpatientapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Symptoms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);
    }

    public void goToMain(View view){
        Intent intent = new Intent(Symptoms.this, MainActivity.class);
        startActivity(intent);
    }

    public void goToConfirm(View view){
        Intent intent = new Intent(Symptoms.this, Confirm.class);
        startActivity(intent);
    }
}
