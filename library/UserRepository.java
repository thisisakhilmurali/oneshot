package com.wecp.library.repository;

import com.wecp.library.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// public interface UserRepository 
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}