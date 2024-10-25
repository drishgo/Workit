package com.Workit.Workit.repo;

import com.Workit.Workit.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);

}
