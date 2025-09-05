package com.superwalletuser.model.request;

import com.superwalletuser.model.entity.UserTypeEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotNull @NotBlank
    private String name;

    @NotNull @NotBlank
    @Pattern(regexp = "(^\\d{11}$)|(^\\d{14}$)")
    private String document;

     @NotNull @NotBlank
     private String password;

     @NotNull
     @Email
     private String email;

     @NotNull
     private UserTypeEnum userType;

}