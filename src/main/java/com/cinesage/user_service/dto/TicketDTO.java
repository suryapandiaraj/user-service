package com.cinesage.user_service.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {

   private Long movieId;
   private Long userId;
   private String seatNumber;
   private String showTime;
   private Long theaterId;

   public TicketDTO(Long movieId, String seatNumber, String showTime, Long userId, Long theaterId) {
      this.movieId = movieId;
      this.seatNumber = seatNumber;
      this.showTime = showTime;
      this.userId = userId;
      this.theaterId = theaterId;
   }

}
