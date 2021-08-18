package com.example.UserResting.Service;


import com.example.UserResting.Service.Dto.UserDTO;


import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IUserService {

     UserDTO create (UserDTO usersDTO);

     Page<UserDTO> read(Integer pageSize, Integer pageNumber);

      UserDTO update (UserDTO userDTO);

     UserDTO getById(Integer idUser);

     Page<UserDTO> queryUsers(String username, Integer pageSize, Integer pageNumber);

     String qForDeleting(Integer id);

}

