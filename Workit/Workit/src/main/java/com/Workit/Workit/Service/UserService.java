package com.Workit.Workit.Service;

import com.Workit.Workit.model.Users;
import com.Workit.Workit.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public Optional<Users> findUsername(String username){
        return userRepo.findByUsername(username);
    }

    public Users createUser(Users users){
       users.setPassword(encoder.encode(users.getPassword()));
        return userRepo.save(users);
    }


    public void deleteUser(int id){
        Optional<Users> user = userRepo.findById(id);
        user.ifPresent(user1 -> userRepo.deleteById(id));

    }

    public Users updateUserEmail(Users users, String newEmail){
        return userRepo.findByUsername(users.getUsername()).map(
                user -> {
                    user.setEmail(newEmail);
                    return userRepo.save(user);
                }
        ).orElseThrow(()->new NullPointerException());
    }
    public Users updateUserPhone(String username, long newPhoneNumber){
        return userRepo.findByUsername(username).map(
                user -> {
                    user.setPhoneNumber(newPhoneNumber);
                    return userRepo.save(user);
                }
        ).orElseThrow(()->new NullPointerException());
    }
    public Users updateUserPassword(Users users, String newPassword){
        return userRepo.findByUsername(users.getUsername()).map(
                user -> {
                    user.setPassword(newPassword);
                    return userRepo.save(user);
                }
        ).orElseThrow(()->new NullPointerException());
    }
}
