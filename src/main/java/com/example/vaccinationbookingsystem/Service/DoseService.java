package com.example.vaccinationbookingsystem.Service;

import com.example.vaccinationbookingsystem.ENUM.DoseType;
import com.example.vaccinationbookingsystem.Exception.PersonAlreadyTakenFirstDose;
import com.example.vaccinationbookingsystem.Exception.PersonNotFoundException;
import com.example.vaccinationbookingsystem.Model.Dose;
import com.example.vaccinationbookingsystem.Model.Person;
import com.example.vaccinationbookingsystem.Repository.DoseRepository;
import com.example.vaccinationbookingsystem.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PersonRepository personRepository;
    public Dose getDose1(int personId, DoseType doseType) {
        Optional<Person> optionalPerson = personRepository.findById(personId);
            if(!optionalPerson.isPresent()){
                throw new PersonNotFoundException("Invalid id Person does'nt present");
            }

            Person person = optionalPerson.get();
            if(person.isDose1Taken()){
                throw new PersonAlreadyTakenFirstDose("Person Already Take Dose 1");
            }

            Dose dose = new Dose();
            dose.setDoesId(String.valueOf(UUID.randomUUID()));
            dose.setDoseType(doseType);
            dose.setPerson(person);

            person.setDose1Taken(true);
            personRepository.save(person);

            return doseRepository.save(dose);

    }
}
