package com.example.UserResting.Domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial")
    private Integer id;

    @Size(min = 5, message = "required min 5")
    @Column(unique = true, nullable = false)
    @NotBlank(message = "NAME is mandatory")
    private String name;

    @NotNull
    @Column(nullable = false)
    private Boolean active;

    @NotNull
    @ManyToOne
     private Rol rol;
}
