package com.Workit.Workit.repo;

import com.Workit.Workit.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepo extends JpaRepository<Profile,Integer> {
    Optional<Profile> findByUserUsername(String username);
}
