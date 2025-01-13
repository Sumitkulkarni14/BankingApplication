package com.sjobs.banking_app.repo;

import com.sjobs.banking_app.entity.UserProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserProperties,Long> {

    //Boolean existsByEmail(String Email);

    Boolean existsByEmail(String email);
}
