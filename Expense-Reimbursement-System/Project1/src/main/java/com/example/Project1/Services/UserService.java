package com.example.Project1.Services;

import com.example.Project1.Models.User;
import com.example.Project1.Repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;
    final Logger logger = LoggerFactory.getLogger(UserService.class);
    /**
     * Constructor
     * @param userRepo
     */
    public UserService(UserRepo userRepo){
        super();
        this.userRepo = userRepo;
    }

    /**
     * Save User in database
     * @param user
     * @return boolean value
     */
    public boolean saveUser(User user){
        userRepo.save(user);
        logger.debug(("New User is saved"));
        return true;
    }

    /**
     * View user by given name
     * @param name
     * @return User instance
     */
    public User viewUserByName(String name){
        logger.debug(("View User by name is triggered"));
        return userRepo.findByName(name);
    }

    /**
     * View user by given id
     * @param id
     * @return User instance
     */
    public Optional<User> viewUserById(int id){
        logger.debug(("View User by Id is triggered"));
        return userRepo.findById(id);
    }

    /**
     * View All Users
     * @return list of Users
     */
    public List<User> viewAllUsers(){
        logger.debug(("List of all User is returned"));
        return userRepo.findAll();
    }

    public boolean deleteTestUsers(){
        userRepo.deleteTestUser();
        return true;
    }

}
