package com.leegeonhee.myum.user.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "myum")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {


    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name="userName",nullable = false)
    private String userName;
    @Column(name="userId",nullable = false,unique = true)
    private String userId;
    @Column(name="userPw",nullable = false)
    private String userPw;


}
