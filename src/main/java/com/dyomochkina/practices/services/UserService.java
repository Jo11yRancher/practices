package com.dyomochkina.practices.services;

import com.dyomochkina.practices.model.User;
import com.dyomochkina.practices.model.enums.Role;
import com.dyomochkina.practices.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public boolean createUser(User user){
        if (userRepository.findByEmail(user.getEmail()) != null)
            return false;

        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return true;
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public void banUser(Long id){
        User user = userRepository.findById(id).orElse(null);
        if (user != null){
            user.setActive(!user.isAdmin());
        }
        userRepository.save(user);
    }
}
