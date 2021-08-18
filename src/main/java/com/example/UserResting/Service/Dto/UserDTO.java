package com.example.UserResting.Service.Dto;

import com.example.UserResting.Domain.Rol;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO {

    @NotNull
    private Integer id;
    private String name;
    private Boolean active;
    private Rol rol;
}
