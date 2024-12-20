package com.Workit.Workit.Service;

import com.Workit.Workit.model.Users;
import com.Workit.Workit.model.UsersPrincipal;
import com.Workit.Workit.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class PrimaryUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return userRepo.findByUsername(username).map(users -> new UsersPrincipal(users))
              .orElseThrow(()->new UsernameNotFoundException("User not found Please register"));
    }
}
