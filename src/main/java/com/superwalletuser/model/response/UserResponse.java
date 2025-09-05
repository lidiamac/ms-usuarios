package com.superwalletuser.model.response;

import com.superwalletuser.model.entity.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    UUID id;
    String name;
    String document;
    String password;
    String email;
    UserTypeEnum userType;
    Boolean active;
}
