package com.klaus.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonEmailDto {
    private Long id;
    private String name;
    private String lastName;

    private String identification;
    private LocalDate dateOfBirth;


}
