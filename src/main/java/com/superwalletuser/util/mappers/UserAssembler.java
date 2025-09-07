package com.superwalletuser.util.mappers;


import com.superwalletuser.domain.entity.User;
import com.superwalletuser.domain.request.UserRequest;
import com.superwalletuser.domain.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAssembler {

    private final ModelMapper mapper;

    public User toEntity(UserRequest request){
        return mapper.map(request, User.class);
    }

    public UserResponse toResponse(User entity){
        return mapper.map(entity, UserResponse.class);
    }

}
