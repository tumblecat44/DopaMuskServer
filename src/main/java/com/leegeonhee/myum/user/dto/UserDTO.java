package com.leegeonhee.myum.user.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    private String userName;
    private String userId;
    private String userPw;
}
