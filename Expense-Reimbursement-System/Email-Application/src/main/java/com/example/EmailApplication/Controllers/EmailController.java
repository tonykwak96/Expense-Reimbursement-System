package com.example.EmailApplication.Controllers;

import com.example.EmailApplication.Models.Email;
import com.example.EmailApplication.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    /**
     * Create a new email
     * @param  to
     * @return
     */
    @PostMapping("/to:{to}")
    public String ResponseEntity (@PathVariable String to){
        return emailService.createEmail(to);
    }

    /**
     * View all Emails
     * @return list of all Emails
     */
    @GetMapping("/all")
    public List<Email> viewAllEmail(){
        return emailService.viewAllEmail();
    }
}
