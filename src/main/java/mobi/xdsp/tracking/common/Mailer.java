package mobi.xdsp.tracking.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class Mailer {
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public void offerManyRedirect(String title, String msg, String offerid, String times, String offername) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("SDK:跳转次数多的offer");
        message.setText(offerid + ">" + offername + ":redirect " + times);
        message.setTo("adnetwork@adscanal.com");
        message.setFrom("notice@adscanal.com");
        javaMailSender.send(message);
    }

}
