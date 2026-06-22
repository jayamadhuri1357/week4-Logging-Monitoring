package jwtsecurity.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jwtsecurity.entity.User;
import jwtsecurity.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger =
            LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public User register(User user) {

        logger.info("Registering user: {}", user.getUsername());

        if (repository.findByUsername(user.getUsername()).isPresent()) {

            logger.error("Username already exists: {}",
                    user.getUsername());

            throw new RuntimeException("Username already exists");
        }

        if (user.getUsername() == null || user.getUsername().isEmpty()) {

            logger.error("Username cannot be empty");

            throw new RuntimeException("Username cannot be empty");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {

            logger.error("Password cannot be empty");

            throw new RuntimeException("Password cannot be empty");
        }

        user.setPassword(encoder.encode(user.getPassword()));

        User savedUser = repository.save(user);

        logger.info("User saved successfully: {}",
                savedUser.getUsername());

        return savedUser;
    }
}