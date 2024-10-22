package com.klaus.dto;

import com.klaus.enums.UserRole;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String userName;
    private String password;
    private String email;

    private UserRole userRole;


}
