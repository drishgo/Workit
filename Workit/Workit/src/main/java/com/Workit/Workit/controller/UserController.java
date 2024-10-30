package com.Workit.Workit.controller;

import com.Workit.Workit.Service.PrimaryUserDetailsService;
import com.Workit.Workit.Service.UserService;
import com.Workit.Workit.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/User/")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    PrimaryUserDetailsService primaryUserDetailsService;

    @PostMapping("/Register")
    public ResponseEntity<Users> registerUser(@RequestBody Users users){
        Optional<Users> user1= Optional.ofNullable(userService.createUser(users));
        return user1.map(savedUser->
        {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{username}")
                    .buildAndExpand(users.getUsername())
                    .toUri();
            return ResponseEntity.created(location).body(users);
        }).orElseGet(()-> ResponseEntity.notFound().build());
    }
    @GetMapping("/{username}")
    public ResponseEntity<Users> showUser(@PathVariable("username") String username){

        return  userService.findUsername(username)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(()->ResponseEntity.notFound().build());
   }

   @DeleteMapping("/delete/{username}")
    public void deleteUser(@PathVariable("username")String username){
        userService.deleteUser(
                userService.findUsername(username).map(
                        user -> user.getId()
                ).orElseGet(()-> {
                    return -1;
                })
        );
    }
    @PatchMapping("/update/Email")
    public void updateEmail(Users users,@RequestBody String email){
        userService.updateUserEmail(users,email);
    }


}
