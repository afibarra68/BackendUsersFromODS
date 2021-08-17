package com.example.UserResting.Service;


import com.example.UserResting.Service.Dto.UserDTO;


import org.springframework.data.domain.Page;

public interface IUserService {

    public UserDTO create (UserDTO usersDTO);

    public Page<UserDTO> read(Integer pageSize, Integer pageNumber);

    public  UserDTO update (UserDTO userDTO);

    public UserDTO getById(Integer idUser);


}

