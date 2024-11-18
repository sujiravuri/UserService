package com.practice.UserService.mapper;

import com.practice.UserService.dto.UserDto;
import com.practice.UserService.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto mapUserToUserDto(User user);
    User mapUserDtoToUser(UserDto userDto);

}
