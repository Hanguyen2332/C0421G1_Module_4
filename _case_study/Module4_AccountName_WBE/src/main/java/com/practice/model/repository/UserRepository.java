package com.practice.model.repository;
import com.practice.model.entity.employee.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String username);
}
