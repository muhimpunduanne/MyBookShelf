package org.example.mybookshef.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail()))
            return "Email already exists";

        if (userRepository.existsByRegNo(registerRequest.getRegNo()))
            return "Reg No already exists";

        if (!registerRequest.getPassword().equals(registerRequest.getConfirmPassword()))
            return "Passwords do not match";

        Users user = new Users();
        user.setRegNo(registerRequest.getRegNo());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        userRepository.save(user);
        return "User registered successfully";
    }
}
