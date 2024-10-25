package com.Workit.Workit.controller;

import com.Workit.Workit.model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/User/update")
public class UserUpdateController extends UserController{

    @PatchMapping("/email")
    public ResponseEntity<Users> updateEmail(Users users){
        return null;
    }
    @PatchMapping("/password")
    public ResponseEntity<Users> updatePassword(Users users){
        return null;
    }
    @PatchMapping("/phoneNumber")
    public ResponseEntity<Users> updatePhoneNum(Users users){
        return null;
    }
}
