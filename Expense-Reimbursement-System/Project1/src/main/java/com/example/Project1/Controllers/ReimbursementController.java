package com.example.Project1.Controllers;

import com.example.Project1.Models.Reimbursement;
import com.example.Project1.Services.ReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/reimbursement")
public class ReimbursementController {

    @Autowired
    ReimbursementService reimbursementService;

    /**
     * Create a new reimbursement
     * @param name of user
     * @param amount
     * @param description
     */
    @PostMapping("/{name},{amount},{description}")
    public void createReimbursement(@PathVariable String name,@PathVariable double amount,@PathVariable String description){
        reimbursementService.createReimbursement(name,amount,description);
    }

    /**
     * Get reimbursements of given user id
     * @param id
     * @return list of reimbursements of given user
     */
    @GetMapping("/id/{id}")
    public List<Reimbursement> viewReimbursementById(@PathVariable int id){
        return reimbursementService.getAllReimbursementById(id);
    }

    /**
     * Get all reimbursements
     * @return all reimbursements
     */
    @GetMapping("/all")
    public List<Reimbursement> viewAllReimbursement(){
        return reimbursementService.getAllReimbursement();
    }

    /**
     * Change status of reimbursement to 'Approved"
     * @param id of reimbursement
     */
    @PutMapping("/approve/{id}")
    public void approveReimbursement(@PathVariable int id){
        reimbursementService.updateReimbursement("Approved",id);
    }

    /**
     * Change status of reimbursement to 'Denied"
     * @param id of reimbursement
     */
    @PutMapping("/deny/{id}")
    public void denyReimbursement(@PathVariable int id){
        reimbursementService.updateReimbursement("Denied",id);
    }

    /**
     * Change user of reimbursement
     * @param user_id
     * @param id of reimbursement
     */
    @PutMapping("/reassign/{user_id},{id}")
    public void reassignReimbursement(@PathVariable int user_id, @PathVariable int id){
        reimbursementService.reassignUser(user_id,id);
    }

    /**
     * Make Post request to Email application
     * @return Successful response
     */
    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public ResponseEntity createEmailRequest() {
        ResponseEntity e = new ResponseEntity(HttpStatus.UNAUTHORIZED);
        return ResponseEntity.ok(reimbursementService.createEmailRequest("Test"));

    }
}
