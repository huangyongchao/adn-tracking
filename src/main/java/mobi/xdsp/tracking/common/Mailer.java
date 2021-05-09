package mobi.xdsp.tracking.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class Mailer {
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public void sendErrorMail(String title, String msg) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(title);
        message.setText(msg);
        message.setTo("adnetwork@adscanal.com");
        message.setFrom("notice@adscanal.com");
        javaMailSender.send(message);
    }

}
