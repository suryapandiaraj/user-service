package com.cinesage.user_service.controller;

import com.cinesage.user_service.dto.MovieResponseDTO;
import com.cinesage.user_service.dto.TicketDTO;
import com.cinesage.user_service.dto.UserCreateDTO;
import com.cinesage.user_service.dto.UserResponseDTO;
import com.cinesage.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/users")
public class UserController {

   private UserService userService;

   @Autowired
   public UserController (UserService userService){
      this.userService = userService;
   }

   @PostMapping("/addUser")
   public ResponseEntity<String> addUser(@RequestBody UserCreateDTO userCreateDTO) {
      userService.addUser(userCreateDTO);
      return ResponseEntity.ok("User signed up!");
   }

   @GetMapping("/getUser/{userId}")
   public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long userId){
      return ResponseEntity.ok(userService.getUser(userId));
   }

   @GetMapping("/getAllUsers")
   public ResponseEntity<Page<UserResponseDTO>> getAllUsers(Pageable pageable){
      return ResponseEntity.ok(userService.getAllUsers(pageable));
   }

   @GetMapping("/searchUser/{searchTerm}")
   public ResponseEntity<Page<UserResponseDTO>> searchUSer(@PathVariable String searchTerm, Pageable pageable){
      return ResponseEntity.ok(userService.searchUser(searchTerm, pageable));
   }

   @GetMapping("/getMovie/{movieId}")
   public ResponseEntity<MovieResponseDTO> getMovie(@PathVariable Long movieId){
      return ResponseEntity.ok(userService.getMovie(movieId));
   }

   @GetMapping("/getAllMovies")
   public ResponseEntity<Page<MovieResponseDTO>> getAllMovies(Pageable pageable){
      return ResponseEntity.ok(userService.getAllMovies(pageable));
   }

   @GetMapping("getAllTickets")
   public ResponseEntity<Page<TicketDTO>> getAllTickets(Pageable pageable){
      return ResponseEntity.ok(userService.getAllTickets(pageable));
   }

   @PatchMapping("/updateUser/{userId}")
   public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody UserCreateDTO userCreateDTO){
      return ResponseEntity.ok(userService.updateUser(userId, userCreateDTO));
   }

}
