package com.klaus.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonDto {
    private Long id;
    private String name;
    private String lastName;
    private LocalDate dateBirth;
}
