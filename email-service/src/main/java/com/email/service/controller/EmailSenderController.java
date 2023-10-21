package com.email.service.controller;

import com.email.service.model.EmailRequest;
import com.email.service.model.exceptions.EmailServiceException;
import com.email.service.service.EmailSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            emailSenderService.sendEmail(emailRequest.to(), emailRequest.subject(), emailRequest.text());
            return ResponseEntity.ok("E-mail enviado com sucesso!");
        } catch (EmailServiceException exception) {
            return ResponseEntity.internalServerError().body("Erro ao enviar e-mail!");
        }
    }
}
