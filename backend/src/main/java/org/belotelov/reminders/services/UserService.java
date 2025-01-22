package org.belotelov.reminders.services;

import org.belotelov.reminders.entity.User;
import org.belotelov.reminders.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }
}
