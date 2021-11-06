package mobi.xdsp.tracking.core.job;

import mobi.xdsp.tracking.common.DateTimeUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.ReceivedDateTerm;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

@Component
public class PidMonitorJob {

    @Scheduled(cron = "0 */2 * * * ?")
    public void exchange() {
        checkAfBlock("shirley@adscanal.com", "Jason2020#","adscanal_int");
        checkAfBlock("kevin@rainbowmobi.com", "Rain2020#","rainbowmobi_int");
        checkAfBlock("russell@mobicoca.com", "Jason2020#","mobicoca_int");
        checkAfBlock("frank@oceanmob.net", "Grid2020#","oceanmob_int");
    }

    public static String parseMultipart(Multipart multipart) throws MessagingException, IOException {
        StringBuffer bodyText = new StringBuffer();
        int count = multipart.getCount();
        for (int idx = 0; idx < count; idx++) {
            BodyPart bodyPart = multipart.getBodyPart(idx);
            if (bodyPart.isMimeType("text/plain")) {
                bodyText.append(bodyPart.getContent());
            } else if (bodyPart.isMimeType("text/html")) {
                bodyText.append(bodyPart.getContent());
            }/* else if (bodyPart.isMimeType("multipart/*")) {
                Multipart mpart = (Multipart) bodyPart.getContent();
                parseMultipart(mpart);
            } else if (bodyPart.isMimeType("application/octet-stream")) {
                try {
                    String disposition = bodyPart.getDisposition();
                    if (disposition.equalsIgnoreCase(BodyPart.ATTACHMENT)) {
                        InputStream is = bodyPart.getInputStream();
                        ByteArrayOutputStream baos=new ByteArrayOutputStream();
                        copy(is, baos);
                        bodyText.append(new String(baos.toByteArray()));
                    }
                } catch (MessagingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/
        }
        return bodyText.toString();
    }


    public static boolean checkAfBlock(String user, String pass,String pid) {
        boolean result = false;
        // 准备连接服务器的会话信息
        try {
            Properties props = new Properties();
            props.setProperty("mail.store.protocol", "imap");
            props.setProperty("mail.imap.host", "imap.mxhichina.com");
            props.setProperty("mail.imap.port", "143");


            // 创建Session实例对象
            Session session = Session.getInstance(props);

            // 创建IMAP协议的Store对象
            Store store = session.getStore("imap");

            // 连接邮件服务器
            //store.connect("tim.x@pubearn.com", "Jason2020#");
            //store.connect("shirley@adscanal.com", "Jason2020#");
            //store.connect("kevin@rainbowmobi.com", "Rain2020#");
            //store.connect("russell@mobicoca.com", "Jason2020#");
            //store.connect("frank@oceanmob.net", "Grid2020#");
            store.connect(user, pass);
            // 获得收件箱
            Folder folder = store.getFolder("INBOX");
            // 以读写模式打开收件箱
            folder.open(Folder.READ_ONLY);
            ReceivedDateTerm term = new ReceivedDateTerm(ComparisonTerm.EQ, DateTimeUtil.getDateBefore(new Date(),0));

            Message[] messages = folder.search(term);
            Arrays.stream(messages).forEach(msg -> {
                try {
                    if(msg.getSubject().indexOf("Abnormal Click Volume - Traffic Blocked ")>=0){
                        try {
                            String cont = msg.getContent().toString();
                            int i = cont.indexOf(" at ");
                            String blockEnd = null;
                            if(i>0){
                                blockEnd = cont.substring(i + 4, i + 9);
                            }
                            System.out.println(pid);
                            System.out.println(DateTimeUtil.dateToStrLong(msg.getSentDate()));
                            System.out.println(DateTimeUtil.dateToStrLong(msg.getReceivedDate()));
                            System.out.println(DateTimeUtil.dateToStr(DateTimeUtil.getDateAfter(msg.getSentDate(), 1))+ " "+blockEnd+":00");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                } catch (MessagingException e) {
                    e.printStackTrace();
                }

            });

            // 关闭资源
            folder.close(false);
            store.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return  result;
    }

    public static void main(String[] args) {
        checkAfBlock("shirley@adscanal.com", "Jason2020#","adscanal_int");
        checkAfBlock("kevin@rainbowmobi.com", "Rain2020#","rainbowmobi_int");
        checkAfBlock("russell@mobicoca.com", "Jason2020#","mobicoca_int");
        checkAfBlock("frank@oceanmob.net", "Grid2020#","oceanmob_int");
    }
}