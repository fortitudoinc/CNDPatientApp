package com.callnigeriandoc.cndpatientapp;

import java.util.ArrayList;

public class PseudoPerson {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private char gender;

    public PseudoPerson(String fname, String lname, String pNumber, char g){
        firstName = fname;
        lastName = lname;
        phoneNumber = pNumber;
        gender = g;
    }

    public ArrayList<String> getErrors(){
        ArrayList<String> ret = new ArrayList<String>();

        if(firstName.isEmpty()){
            ret.add("@string/firstNameEmpty");
        }

        if(lastName.isEmpty()){
            ret.add("@string/lastNameEmpty");
        }

        if(phoneNumber.isEmpty()){
            ret.add("@string/phoneNumberEmpty");
        }

        if(gender != 'M' && gender != 'F'){
            ret.add("@string/genderEmpty");
        }

        return ret;
    }
}
