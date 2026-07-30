package com.cfs.CREDENCE_20.repository;

import com.cfs.CREDENCE_20.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUid(String uid);

    Optional<User> findByEmail(String email); // used at login and by the JWT filter to load the authenticated user
}
