package mobi.xdsp.tracking.core.job;

import mobi.xdsp.tracking.common.DateTimeUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SearchTerm;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import static org.apache.tomcat.util.http.fileupload.IOUtils.copy;

@Component
public class EmailRevJob {

    @Scheduled(cron = "0 20,40,59 * * * ?")
    public void exchange() {

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


    public static boolean checkAfBlock(String user, String pass) {
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
            ReceivedDateTerm term = new ReceivedDateTerm(ComparisonTerm.EQ, DateTimeUtil.getDateBefore(new Date(),1));

            Message[] messages = folder.search(term);
            // 获得收件箱的邮件列表


            // 打印不同状态的邮件数量
            System.out.println("收件箱中共" + messages.length + "封邮件!");
            System.out.println("收件箱中共" + folder.getUnreadMessageCount() + "封未读邮件!");
            System.out.println("收件箱中共" + folder.getNewMessageCount() + "封新邮件!");
            System.out.println("收件箱中共" + folder.getDeletedMessageCount() + "封已删除邮件!");

            System.out.println("------------------------开始解析邮件----------------------------------");

            Arrays.stream(messages).forEach(msg -> {
                try {
                    if(msg.getSubject().indexOf("荣耀大天使")>0){
                        try {
                            String cont = parseMultipart((Multipart) msg.getContent());
                            int i = cont.indexOf("服务端上报链接");
                            int j = cont.indexOf("上报方式");

                            int f = msg.getSubject().indexOf("【");
                            int ff = msg.getSubject().indexOf("】");
                            String link = cont.substring(i + 8, j);
                            int k = link.indexOf("</div>");
                            System.out.println(msg.getSubject().substring(f+1,ff)+"@"+link.substring(0,k).trim());

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
   /*     checkAfBlock("tim.x@pubearn.com", "Jason2020#");
        checkAfBlock("shirley@adscanal.com", "Jason2020#");
        checkAfBlock("kevin@rainbowmobi.com", "Rain2020#");
        checkAfBlock("russell@mobicoca.com", "Jason2020#");*/
        checkAfBlock("frank@oceanmob.net", "Grid2020#");
    }
}