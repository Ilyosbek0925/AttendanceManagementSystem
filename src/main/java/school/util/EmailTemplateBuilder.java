package school.util;

import org.springframework.stereotype.Component;

@Component
public class EmailTemplateBuilder {

    public String buildVerificationCode(String authorName, Integer code) {
        return "Dear " + authorName + "\n" +
                "Welcome to our system 😉" + "\n" +
                "Your verification code 🗝️: " + code;
    }


    public String buildBlockMessage(String authorName) {
        return "Dear " + authorName + "\n" +
                "Unfortunately, your account has blocked";
    }

    public String buildUnBlockMessage(String authorName) {
        return "Dear " + authorName + "\n" +
                "Your account unlocked" +"\n"+
                "We hope you never do anything forbidden.";
    }

    public String buildForgetPasswordCodeBody(String authorName, int code ) {
        return "Dear " + authorName +"\n"+
                "Do you want change your password ?" + "\n"+
                "It is your code confirmation: " + code;
    }

    public String buildMessageAboutPasswordChanged(String authorName ) {
        return "Dear " + authorName +"\n"+
                "Your password successfully changed";
    }
}
