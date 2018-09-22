package com.callnigeriandoc.cndpatientapp;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class PseudoPersonTest {

    @Test
    public void testGetErrors(){
        ArrayList<Integer> results;

        PseudoPerson validPerson = new PseudoPerson(
                "Bob",
                "Smith",
                "5555555555",
                "Male"
        );

        results = validPerson.getErrors();

        assertEquals("A valid person failed Psuedo Person validation", 0, results.size());

        PseudoPerson invalidGenderPerson = new PseudoPerson(
                "Bob",
                "Smith",
                "5555555555",
                "Blue"
        );

        results = invalidGenderPerson.getErrors();

        assertNotEquals("A Pseudo Person with invalid gender passed validation", 0, results.size());

        PseudoPerson[] emptyFieldPsuedoPeople = {
                new PseudoPerson("", "test", "55555555", "Male"),
                new PseudoPerson("Bob", "", "555555555", "Male"),
                new PseudoPerson("Bob", "Smith", "", "Male"),
                new PseudoPerson("Bob", "Smith", "555555555", "")
        };

        for (PseudoPerson emptyFieldPsuedoPerson : emptyFieldPsuedoPeople){
            results = emptyFieldPsuedoPerson.getErrors();
            assertNotEquals("A PseudoPerson with an empty field passed validation", 0, results.size());

        }

    }
}
