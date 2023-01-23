package com.example.bookYourShow.Service;

import com.example.bookYourShow.Dtos.UserRequestDto;
import com.example.bookYourShow.Modals.UserEntity;
import com.example.bookYourShow.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String createUser(UserRequestDto userRequestDto){

        //Converted the userRequestDto to UserEntity
        UserEntity userEntity = UserEntity.builder().name(userRequestDto.getName()).mobile(userRequestDto.getMobileNo()).build();

        try{
            userRepository.save(userEntity);

        }catch(Exception e){
            return "user couldn't be added";
        }
        return "User added successfully";
    }
}
