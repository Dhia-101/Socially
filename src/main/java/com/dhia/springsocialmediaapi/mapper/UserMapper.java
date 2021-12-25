package com.dhia.springsocialmediaapi.mapper;

import com.dhia.springsocialmediaapi.domain.User;
import com.dhia.springsocialmediaapi.model.UserDTO;
import org.mapstruct.factory.Mappers;

public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);
}
