package com.productionlogs.service;

import com.productionlogs.dto.UserDto;
import com.productionlogs.entity.User;
import com.productionlogs.entity.UserRole;
import com.productionlogs.repository.UserRepository;
import com.productionlogs.service.mapper.UserMapper;
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
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
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

    public User mapToUser(UserDto userDto) {
        return userMapper.mapUserDtoToUser(userDto);
    }

    public void save(User user) {
        user.setUser_password(encoder.encode(user.getPassword()));
        user.setRoles(Set.of(UserRole.WORKER));
        userRepository.save(user);
    }
}
