package com.cinesage.user_service.mapper;

import com.cinesage.user_service.dto.UserCreateDTO;
import com.cinesage.user_service.dto.UserResponseDTO;
import com.cinesage.user_service.entity.User;

public class UserMapper {

   public static UserCreateDTO toCreateDTO(User user){
      if(user == null)  return null;

      return new UserCreateDTO(
              user.getUserName(),
              user.getUserEmail(),
              user.getPassword(),
              user.getPhoneNumber()
      );
   }

   public static UserResponseDTO toResponseDTO(User user){
      if(user == null)  return null;

      return new UserResponseDTO(user.getUserName(), user.getUserEmail());
   }

}
