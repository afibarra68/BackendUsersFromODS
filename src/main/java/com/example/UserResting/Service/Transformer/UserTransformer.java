package com.example.UserResting.Service.Transformer;

import com.example.UserResting.Domain.Users;
import com.example.UserResting.Service.Dto.UserDTO;

public class UserTransformer {

    public static UserDTO getUsersDTOFromUsers(Users users){
        if (users == null){
            return  null;
        }
        UserDTO dto = new UserDTO();

        dto.setId(users.getId());
        dto.setName(users.getName());
        dto.setActive(users.getActive());
        dto.setRol(users.getRol());

        return dto;
    }

    public static Users getUsersFromUsersDTO (UserDTO dto){

        if (dto == null){
            return null;
        }

        Users users = new Users();

        users.setId(dto.getId());
        users.setName(dto.getName());
        users.setActive(dto.getActive());
        users.setRol(dto.getRol());

        return users;
    }
}
