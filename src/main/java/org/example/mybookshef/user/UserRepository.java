package org.example.mybookshef.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<Users, Long> {
    Boolean existsByEmail(String email);
   Boolean existsByRegNo (String regNo);
}
