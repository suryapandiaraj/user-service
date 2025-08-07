package com.cinesage.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserCreateDTO {

   private String userName;
   private String userEmail;
   private String password;
   private String phoneNumber;

}
