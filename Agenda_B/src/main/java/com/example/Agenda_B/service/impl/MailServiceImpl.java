package com.example.Agenda_B.service.impl;

import com.example.Agenda_B.domain.NotifEmail;
import com.example.Agenda_B.dto.MailMethods;
import com.example.Agenda_B.exception.NotFoundException;
import com.example.Agenda_B.service.MailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static java.awt.Desktop.Action.MAIL;

@Service
@AllArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

    private final static String FROM= String.valueOf(MAIL);
    private final JavaMailSender mailSender;

    @Async
    public
    void sendMail(NotifEmail notificationEmail) {
        MailMethods mailMethods = new MailMethods();
        mailMethods.sendMail(notificationEmail, FROM, mailSender);
    }
}
