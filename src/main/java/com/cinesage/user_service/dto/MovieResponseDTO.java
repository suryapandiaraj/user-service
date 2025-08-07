package com.cinesage.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MovieResponseDTO {

   private String movieName;
   private int year;
   private String genre;

}
