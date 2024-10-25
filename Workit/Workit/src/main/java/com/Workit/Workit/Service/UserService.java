package com.Workit.Workit.Service;

import com.Workit.Workit.model.Users;
import com.Workit.Workit.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public Optional<Users> findUsername(String username){
        return userRepo.findByUsername(username);
    }

    public Users createUser(Users users){
       return userRepo.save(users);
    }


    public void deleteUser(int id){
        Optional<Users> user = userRepo.findById(id);
        user.ifPresent(user1 -> userRepo.deleteById(id));

    }

    public Users updateUserEmail(String username, String newEmail){
        return userRepo.findByUsername(username).map(
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
    public Users updateUserPassword(String username, String newPassword){
        return userRepo.findByUsername(username).map(
                user -> {
                    user.setPassword(newPassword);
                    return userRepo.save(user);
                }
        ).orElseThrow(()->new NullPointerException());
    }
}
