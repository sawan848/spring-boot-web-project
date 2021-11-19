package com.example.springbootwebproject.repository;

import com.example.springbootwebproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Saawan
 * On 19 Nov, 2021
 * 6:33 PM
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
