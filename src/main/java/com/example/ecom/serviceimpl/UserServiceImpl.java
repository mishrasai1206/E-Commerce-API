package com.example.ecom.serviceimpl;

import com.example.ecom.dto.request.UserRegistrationRequest;
import com.example.ecom.dto.request.UserRequest;
import com.example.ecom.dto.response.UserResponse;
import com.example.ecom.exception.UserNotFoundByIdException;
import com.example.ecom.mapper.UserMapper;
import com.example.ecom.model.Customer;
import com.example.ecom.model.Seller;
import com.example.ecom.model.User;
import com.example.ecom.repository.UserRepository;
import com.example.ecom.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserResponse register(UserRegistrationRequest registrationRequest) {
        User user = null;

        switch (registrationRequest.getUserRole()) {
            case SELLER -> user = new Seller();
            case CUSTOMER -> user = new Customer();
        }

        userMapper.mapToUser(registrationRequest, user);
        userRepository.save(user);
        return userMapper.mapToUserResponse(user);
    }

    @Override
    public UserResponse findByUserId(String id) {
       return userRepository.findById(id)
                .map(userMapper::mapToUserResponse)
                .orElseThrow(() -> new UserNotFoundByIdException("Failed to find User"));
    }

    @Override
    public UserResponse updateByUserId(String id, UserRequest userRequest) {
        return userRepository.findById(id)
                .map(exUser -> {
                    userMapper.mapToUser(userRequest,exUser);
                    userRepository.save(exUser);
                    return userMapper.mapToUserResponse(exUser);
                }).orElseThrow(() -> new UserNotFoundByIdException("Failed to find User"));
    }
}
