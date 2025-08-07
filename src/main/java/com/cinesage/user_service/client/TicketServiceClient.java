package com.cinesage.user_service.client;

import com.cinesage.user_service.dto.TicketDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ticket-service", url =  "http://localhost:8082/tickets")
public interface TicketServiceClient {

   @GetMapping("/getAllTickets")
   public Page<TicketDTO> getAllTickets(Pageable pageable);

}
