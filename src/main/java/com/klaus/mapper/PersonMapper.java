package com.klaus.mapper;

import com.klaus.dto.PersonDto;
import com.klaus.dto.PersonEmailDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonEmailDto toPersonResponse(PersonDto personDto);
}
