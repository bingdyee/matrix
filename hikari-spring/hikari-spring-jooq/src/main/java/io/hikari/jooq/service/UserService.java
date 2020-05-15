package io.hikari.jooq.service;

import io.hikari.jooq.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author Noa Swartz
 */
@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
