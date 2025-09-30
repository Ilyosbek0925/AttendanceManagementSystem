package school.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import school.entity.UserEntity;
import school.exception.DataNotFoundException;
import school.repository.UserRepository;
import school.service.EmailService;
import school.util.EmailTemplateBuilder;

import java.security.SecureRandom;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;
    private final UserRepository userRepository;

    @Value("${app.email.admin.notification}")
    private String adminEmail;

    @Value("${app.email.submission.address}")
    private String submissionEmail;
    private final EmailTemplateBuilder emailTemplateBuilder;



    @Override
    public void sendVerificationCode(String name,String mail, int verificationCode) {
        try {
            userRepository.findByMail(mail);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(mail);
            message.setSubject("Verification Code");
            message.setText(emailTemplateBuilder.buildVerificationCode(name, verificationCode));
            mailSender.send(message);
            log.info("Verification code sent");
        } catch (Exception e) {
            log.error("Failed to send verification code to {}: {}", mail, e.getMessage());
        }
    }


    @Override
    public void sendUnBlockOrBlockMessage(String email,boolean status) {
        UserEntity user = userRepository.findByMail(email).orElseThrow(() -> new DataNotFoundException("User not found"));
        if (!status) {
            try {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(email);
                message.setFrom(submissionEmail);
                message.setSubject("Block Message");
                message.setText(emailTemplateBuilder.buildBlockMessage(user.getFirstName()));
                mailSender.send(message);
                log.info("Block message sent");
            } catch (Exception e) {
                log.error("Failed to send block message to {}: {}", email, e.getMessage());
            }
        }else {
            try {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(email);
                message.setFrom(submissionEmail);
                message.setSubject("UnBlock Message");
                message.setText(emailTemplateBuilder.buildUnBlockMessage(user.getFirstName()));
                mailSender.send(message);
                log.info("UnBlock message sent");
            } catch (Exception e) {
                log.error("Failed to send unblock message to {}: {}", email, e.getMessage());
            }
        }
    }

    @Override
    public void sendForgetPasswordConfirmationCode(String email,Integer code) {
        UserEntity user = userRepository.findByMail(email).orElseThrow(() -> new DataNotFoundException("User not found"));
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Forget Password Confirmation Code");
            message.setText(emailTemplateBuilder.buildForgetPasswordCodeBody(user.getFirstName(), code));
            mailSender.send(message);
            log.info("Forget password confirmation code sent");
        } catch (Exception e) {
            log.error("Failed to send forget password confirmation code to {}: {}", email, e.getMessage());
        }
    }

    @Override
    public void sendMessageAboutPasswordChanged(String email) {
        UserEntity user = userRepository.findByMail(email).orElseThrow(() -> new DataNotFoundException("User not found"));
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Password Changed");
            message.setText(emailTemplateBuilder.buildMessageAboutPasswordChanged(user.getFirstName()));
            mailSender.send(message);
            log.info("Password changed to {}", email);
        } catch (Exception e) {
            log.error("Failed to send message about password changed to {}: {}", email, e.getMessage());
        }
    }


    private String generateUniqueToken() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder token = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < 10; i++) {
            token.append(chars.charAt(random.nextInt(chars.length())));
        }
        return token.toString();
    }

}
