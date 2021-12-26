package com.dhia.springsocialmediaapi.mapper;

import com.dhia.springsocialmediaapi.domain.User;
import com.dhia.springsocialmediaapi.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    UserDTO UserToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);
}
