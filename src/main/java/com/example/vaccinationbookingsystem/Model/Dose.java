package com.example.vaccinationbookingsystem.Model;

import com.example.vaccinationbookingsystem.ENUM.DoseType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter

public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String doesId;

    @Enumerated(EnumType.STRING)
    DoseType doseType;

    @CreationTimestamp
    Date vaccinationDate;

    @ManyToOne
    @JoinColumn
    Person person;

}
