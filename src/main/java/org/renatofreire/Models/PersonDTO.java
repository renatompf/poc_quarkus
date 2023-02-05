package org.renatofreire.Models;

import java.time.LocalDate;

public record PersonDTO(
        String name,
        LocalDate dateOfBirth,
        String email){}
