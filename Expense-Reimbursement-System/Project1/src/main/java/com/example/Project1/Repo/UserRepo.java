package com.example.Project1.Repo;

import com.example.Project1.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepo extends JpaRepository <User, Integer> {

    /**
     * Find user by name
     * @param name
     * @return User instance
     */
    User findByName(String name);

    /**
     * Find user by id
     * @param id
     * @return User instance
     */
    Optional<User> findById(Integer id);

    @Transactional
    @Modifying
    @Query(value ="delete from users where user_name = 'TestUser'", nativeQuery = true)
    void deleteTestUser();
}
