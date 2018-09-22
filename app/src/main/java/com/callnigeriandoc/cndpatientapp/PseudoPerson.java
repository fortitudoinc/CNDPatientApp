package com.callnigeriandoc.cndpatientapp;

import java.util.ArrayList;

public class PseudoPerson {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String gender;

    PseudoPerson(String fname, String lname, String pNumber, String g){
        firstName = fname;
        lastName = lname;
        phoneNumber = pNumber;
        gender = g;
    }

    public ArrayList<Integer> getErrors(){
        ArrayList<Integer> ret = new ArrayList<Integer>();

        if(firstName.isEmpty()){
            ret.add(R.string.firstNameEmpty);
        }

        if(lastName.isEmpty()){
            ret.add(R.string.lastNameEmpty);
        }

        if(phoneNumber.isEmpty()){
            ret.add(R.string.phoneNumberEmpty);
        }

        if(!gender.equals("Male") && !gender.equals("Female")){ // TODO: Make these string resources?
            ret.add(R.string.genderEmpty);
        }

        return ret;
    }
}
