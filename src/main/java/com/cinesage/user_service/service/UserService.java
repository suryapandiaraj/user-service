package com.cinesage.user_service.service;

import com.cinesage.user_service.client.MovieServiceClient;
import com.cinesage.user_service.client.TicketServiceClient;
import com.cinesage.user_service.dto.MovieResponseDTO;
import com.cinesage.user_service.dto.TicketDTO;
import com.cinesage.user_service.dto.UserCreateDTO;
import com.cinesage.user_service.dto.UserResponseDTO;
import com.cinesage.user_service.entity.User;
import com.cinesage.user_service.exception.UserNotFoundException;
import com.cinesage.user_service.mapper.UserMapper;
import com.cinesage.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UserService {

//   @Autowired
   private UserRepository userRepository;

//   @Autowired
   private MovieServiceClient movieServiceClient;

//   @Autowired
   private TicketServiceClient ticketServiceClient;

   @Autowired
   public UserService(UserRepository userRepository, MovieServiceClient movieServiceClient, TicketServiceClient ticketServiceClient) {
      this.movieServiceClient = movieServiceClient;
      this.userRepository = userRepository;
      this.ticketServiceClient = ticketServiceClient;
   }

   public UserResponseDTO getUser(Long userId) {
      return userRepository.findById(userId)
              .map(UserMapper::toResponseDTO)
              .orElseThrow(() -> new UserNotFoundException("User not found!"));
   }

   public Page<UserResponseDTO> getAllUsers(Pageable pageable){
      return userRepository.findAll(pageable).map(UserMapper::toResponseDTO);
   }

   public Page<UserResponseDTO> searchUser(String searchTerm, Pageable pageable) {
      return userRepository.searchUser(searchTerm, pageable);
   }

   public MovieResponseDTO getMovie(Long movieId){
      return movieServiceClient.getMovie(movieId);
   }

   public void addUser(UserCreateDTO userCreateDTO) {
      User user = new User(
              userCreateDTO.getUserName(),
              userCreateDTO.getUserEmail(),
              userCreateDTO.getPassword(),
              userCreateDTO.getPhoneNumber()
      );
      userRepository.save(user);
   }

   public Page<MovieResponseDTO> getAllMovies(Pageable pageable){
      return movieServiceClient.getAllMovies(pageable);
   }

   public Page<TicketDTO> getAllTickets(Pageable pageable){
      return ticketServiceClient.getAllTickets(pageable);
   }

   public String updateUser(Long userId, UserCreateDTO userCreateDTO){
      User user = userRepository.findById(userId).get();
      if(user == null) {
         throw new UserNotFoundException("User not found!");
      }
      if(userCreateDTO.getUserName() != null){
         user.setUserName(userCreateDTO.getUserName());
      }
      if(userCreateDTO.getUserEmail() != null){
         user.setUserEmail(userCreateDTO.getUserEmail());
      }
      if(userCreateDTO.getPassword() != null){
         user.setPassword(userCreateDTO.getPassword());
      }
      if(userCreateDTO.getPhoneNumber() != null){
         user.setPhoneNumber(userCreateDTO.getPhoneNumber());
      }
      userRepository.save(user);
      return "User updated!";
   }

}
