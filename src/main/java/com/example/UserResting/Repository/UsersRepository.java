package com.example.UserResting.Repository;

import com.example.UserResting.Domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {

}
