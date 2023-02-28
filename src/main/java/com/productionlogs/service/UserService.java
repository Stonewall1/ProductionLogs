package com.productionlogs.service;

import com.productionlogs.entity.User;
import com.productionlogs.entity.UserRole;
import com.productionlogs.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byUsername = userRepository.findByUsername(username);
        if (byUsername.isPresent()) {
            return byUsername.get();
        } else throw new UsernameNotFoundException(username);
    }

    public void createAdmin() {
        if (!userRepository.existsByUsername("Valik")) {
            User admin = new User();
            admin.setUsername("Valik");
            admin.setPassword(encoder.encode("111"));
            admin.setFirstName("FirstName");
            admin.setLastName("LastName");
            admin.setRoles(Set.of(UserRole.ADMIN));
            userRepository.save(admin);
        }
    }

    public User findByUsername(String username) {
        return findByUsername(username);
    }

}
