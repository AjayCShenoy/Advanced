package com.spring.websecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.websecurity.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    
}
