package com.cinesage.user_service.client;

import com.cinesage.user_service.dto.MovieResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "movie-service", url = "http://localhost:8081/movies")
public interface MovieServiceClient {

   @GetMapping("/getMovie/{movieId}")
   MovieResponseDTO getMovie(@PathVariable Long movieId);

   @GetMapping("/getAllMovies")
   Page<MovieResponseDTO> getAllMovies(Pageable pageable);

}
