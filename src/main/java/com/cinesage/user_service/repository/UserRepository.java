package com.cinesage.user_service.repository;

import com.cinesage.user_service.dto.UserResponseDTO;
import com.cinesage.user_service.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   @Query("select u from User u where lower(u.userName) like lower(concat('%', :searchTerm, '%'))")
   Page<UserResponseDTO> searchUser(String searchTerm, Pageable pageable);

}
