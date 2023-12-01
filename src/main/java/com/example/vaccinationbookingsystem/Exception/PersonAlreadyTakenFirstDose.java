package com.example.vaccinationbookingsystem.Exception;

public class PersonAlreadyTakenFirstDose extends RuntimeException{
    public PersonAlreadyTakenFirstDose(String message){
        super(message);
    }
}
