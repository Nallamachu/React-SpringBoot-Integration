package com.softifyo.hospital.service;

import com.softifyo.hospital.entities.Role;
import com.softifyo.hospital.entities.User;
import com.softifyo.hospital.repository.RoleRepository;
import com.softifyo.hospital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder encoder;

    public User register(String username, String password, List<String> roleNames) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));

        Set<Role> roles = roleNames.stream()
                .map(roleRepo::findByName)
                .collect(Collectors.toSet());

        user.setRoles(roles);
        return userRepo.save(user);
    }
}
