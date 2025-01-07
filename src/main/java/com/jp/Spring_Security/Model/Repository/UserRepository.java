package com.jp.Spring_Security.Model.Repository;

import com.jp.Spring_Security.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public @Repository interface UserRepository extends JpaRepository<User,Long> {
     Optional<User> findByName(String name);
}
