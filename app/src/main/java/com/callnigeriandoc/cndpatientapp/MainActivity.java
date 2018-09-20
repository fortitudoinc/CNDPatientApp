package com.callnigeriandoc.cndpatientapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void validateAndSave(View view){
        String selectedGender;

        String firstName = ((EditText) findViewById(R.id.firstNameVal)).getText().toString();
        String lastName = ((EditText) findViewById(R.id.lastNameVal)).getText().toString();
        String phoneNumber = ((EditText) findViewById(R.id.phoneNumberVal)).getText().toString();

        try{
            RadioGroup genderRadioGroup = findViewById(R.id.genderVal);
            int genderId = genderRadioGroup.getCheckedRadioButtonId();
            View checkedGenderRadioButtonView = genderRadioGroup.findViewById(genderId); // Check for NPE here?
            int checkedGenderRadioButtonId = genderRadioGroup.indexOfChild(checkedGenderRadioButtonView);
            RadioButton checkedGenderRadioButton = (RadioButton) genderRadioGroup.getChildAt(checkedGenderRadioButtonId);
            selectedGender = (String) checkedGenderRadioButton.getText();
        }catch(NullPointerException e){
            selectedGender = "";
        }

        PseudoPerson p = new PseudoPerson(firstName, lastName, phoneNumber, selectedGender);
        ArrayList<Integer> errors = p.getErrors();

    }

    public void goToConfirm(View view){
        Intent intent = new Intent(MainActivity.this, Confirm.class);
        startActivity(intent);
    }
}
