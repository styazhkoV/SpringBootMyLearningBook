package com.snowsolutions.skd.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Collection;
@Data
@Builder
public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;

}
