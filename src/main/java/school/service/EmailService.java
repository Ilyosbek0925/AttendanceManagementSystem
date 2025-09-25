package school.service;

import java.util.UUID;

public interface EmailService {
    void sendVerificationCode(String name,String mail, int verificationCode);
    void sendUnBlockOrBlockMessage(String email,boolean status);
    void sendForgetPasswordConfirmationCode (String email,Integer code);
    void sendMessageAboutPasswordChanged(String email);
}
