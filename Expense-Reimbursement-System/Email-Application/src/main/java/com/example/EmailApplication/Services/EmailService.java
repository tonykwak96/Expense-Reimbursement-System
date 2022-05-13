package com.example.EmailApplication.Services;

import com.example.EmailApplication.Models.Email;
import com.example.EmailApplication.Repo.EmailRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EmailService {

    private EmailRepo emailRepo;
    final Logger logger = LoggerFactory.getLogger(EmailService.class);
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    /**
     * Constructor
     * @param emailRepo
     */
    public EmailService(EmailRepo emailRepo){
        super();
        this.emailRepo = emailRepo;
    }

    /**
     * Create Email
     * @param Receiver email address
     * @return
     */
    public String createEmail(String to){
        Email email = new Email();
        email.setDate(dtf.format(now));
        email.setReceiver(to);
        emailRepo.save(email);
        logger.debug(("New Email is created"));
        return "Email created";
    }

    /**
     * View All Emails
     * @return list of all emails
     */
    public List<Email> viewAllEmail() {
        logger.debug(("List of all Emails is returned"));
        return emailRepo.findAll();
    }
}
