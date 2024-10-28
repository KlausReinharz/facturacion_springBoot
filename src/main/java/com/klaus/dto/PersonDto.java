package com.klaus.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class PersonDto {
    private Long id;
    private String name;
    private String lastName;
    private String emailGenerated;
    private String identification;
    private LocalDate dateOfBirth;

}
