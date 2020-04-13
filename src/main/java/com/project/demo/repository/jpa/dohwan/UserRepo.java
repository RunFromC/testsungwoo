package com.project.demo.repository.jpa.dohwan;

import com.project.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
