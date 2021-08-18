package com.example.UserResting.Service.Implements;


import com.example.UserResting.Domain.Users;
import com.example.UserResting.Repository.UsersRepository;
import com.example.UserResting.Service.Dto.UserDTO;
import com.example.UserResting.Service.IUserService;
import com.example.UserResting.Service.Transformer.UserTransformer;
import com.example.UserResting.Service.error.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImplements implements IUserService {


    private final UsersRepository userRepo;

    public UsersServiceImplements(UsersRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDTO create(UserDTO usersDTO) {
        Users users = UserTransformer.getUsersFromUsersDTO(usersDTO);
        return UserTransformer.getUsersDTOFromUsers(userRepo.save(users));
    }

    @Override
    public Page<UserDTO> read(Integer pageSize, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return userRepo.findAll(pageable)
                .map(UserTransformer::getUsersDTOFromUsers);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO getById(Integer idUser) {
        return null;
    }


}
