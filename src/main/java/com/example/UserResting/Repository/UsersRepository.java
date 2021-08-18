package com.example.UserResting.Repository;

import com.example.UserResting.Domain.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users,Integer> {

    Page<Users> findAllByNameContains(@Param("name") String name,  Pageable pageable);



}
