package com.example.UserResting.Service.Dto;

import com.example.UserResting.Domain.Rol;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDTO {

    @NotNull
    private Integer id;

    @NotEmpty(message = "Field Required")
    @Size(min = 5, message = "required min 5")
    @Column(unique = true, length = 45)
    private String name;

    @NotNull
    @NotEmpty(message = "Field Required")
    private Boolean active;

    @NotEmpty(message = "Field Required")
    @ManyToOne
    private Rol rol;
}
