package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.*;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
	User findByUserId(String user_id);
}
