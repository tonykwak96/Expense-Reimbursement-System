package com.example.Project1.Services;

import com.example.Project1.Models.Reimbursement;
import com.example.Project1.Models.User;
import com.example.Project1.Repo.ReimbursementRepo;
import com.example.Project1.Repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;


@Service
public class ReimbursementService {

    private ReimbursementRepo reimbursementRepo;
    private UserRepo userRepo;

    @Value("${EMAIL_URL")
    private String emailURL;

    final Logger logger = LoggerFactory.getLogger(ReimbursementService.class);

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    /**
     * Constructor
     * @param reimbursementRepo
     * @param userRepo
     */
    public ReimbursementService(ReimbursementRepo reimbursementRepo,UserRepo userRepo){
        super();
        this.reimbursementRepo = reimbursementRepo;
        this.userRepo = userRepo;
    }

    /**
     * Create Reimbursement
     * @param userName
     * @param amount
     * @param description
     * @return boolean value
     */
    public boolean createReimbursement(String userName, double amount, String description){
        User user = userRepo.findByName(userName);
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setAmount(amount);
        reimbursement.setDate(dtf.format(now));
        reimbursement.setStatus("Pending");
        reimbursement.setDescription(description);
        reimbursement.setUser(user);
        reimbursementRepo.save(reimbursement);
        logger.debug(("New Reimbursement is created"));
        return true;
    }

    /**
     * Update Reimbursement status
     * @param status
     * @param id
     * @return boolean value
     */
    public boolean updateReimbursement(String status, int id){
        reimbursementRepo.updateStatusById(status,id);
        logger.debug(("Reimbursement is updated"));
        return true;
    }

    /**
     * Update Reimbursement user
     * @param user_id
     * @param id
     * @return boolean value
     */
    public boolean reassignUser(int user_id, int id){
        reimbursementRepo.updateUserById(user_id,id);
        logger.debug(("Reimbursement is reassigned"));
        return true;
    }

    /**
     * Get all Reimbursements of given id
     * @param id
     * @return list of Reimbursements
     */
    public List<Reimbursement> getAllReimbursementById(int id){
        logger.debug(("List of Reimbursements is returned"));
        return reimbursementRepo.findAllById(id);
    }

    /**
     * Get all Reimbursements
     * @return list of Reimbursements
     */
    public List<Reimbursement> getAllReimbursement(){
        logger.debug(("List of all Reimbursements is returned"));
        return reimbursementRepo.findAll();
    }

    /**
     * Create Email Request to email application
     * @param str
     * @return
     */
    public String createEmailRequest(String str){
        RestTemplate tmp = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<>(str);
        String url = "http://emailapp:8000/email/to:test";
        ResponseEntity<String> response = tmp.exchange(url,HttpMethod.POST,request,String.class);
        return response.toString();
    }

}
