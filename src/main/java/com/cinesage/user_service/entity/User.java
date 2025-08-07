package com.cinesage.user_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long userId;

   @Column(unique = true, nullable = false)
   private String userName;

   @Column(unique = true, nullable = false)
   private String userEmail;

   @Column
   private String phoneNumber;

   @Column(nullable = false)
   private String password;

   public User(String userName, String userEmail, String password, String phoneNumber) {
      this.userName = userName;
      this.userEmail = userEmail;
      this.password = password;
      this.phoneNumber = phoneNumber;
   }

}
