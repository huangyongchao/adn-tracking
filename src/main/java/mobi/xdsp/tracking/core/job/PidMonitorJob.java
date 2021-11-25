package mobi.xdsp.tracking.core.job;

import com.google.common.collect.Lists;
import mobi.xdsp.tracking.common.DateTimeUtil;
import mobi.xdsp.tracking.common.Mailer;
import mobi.xdsp.tracking.dto.enums.StateE;
import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.OfferExample;
import mobi.xdsp.tracking.entity.PidMonitor;
import mobi.xdsp.tracking.entity.PidMonitorExample;
import mobi.xdsp.tracking.mapper.OfferMapper;
import mobi.xdsp.tracking.mapper.PidMonitorMapper;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.mail.*;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.ReceivedDateTerm;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Component
public class PidMonitorJob {
    @Autowired
    Mailer mailer;
    @Autowired
    private PidMonitorMapper pidMonitorMapper;

    @Autowired
    private OfferMapper offerMapper;


    @Scheduled(cron = "0 1,31 * * * ?")
    public void pidActiveChecker() {
        Date cdate = new Date();

        OfferExample example = new OfferExample();
        List<PidMonitor> pidMonitors = pidMonitorMapper.selectByExample(new PidMonitorExample());
        pidMonitors.forEach(pidMonitor -> {
            try {
                if(pidMonitor.getBlocket()==null){
                    pidMonitor.setBlocket(new Date());
                }
                if (pidMonitor.getBlocket().before(cdate)) {
                    mailer.sendFrankMail("Pid Monitor Active" + pidMonitor.getPid(), pidMonitor.getPid() + DateTimeUtil.dateToStrLong(cdate));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        example.createCriteria().andStatusEqualTo(StateE.PIDBLOCK.name);


        List<Offer> offers = offerMapper.selectByExample(example);

        if (!CollectionUtils.isEmpty(offers)) {
            List<Integer> offeruids = Lists.newLinkedList();
            offers.forEach(n -> {
                if (needActive(n, pidMonitors)) {
                    offeruids.add(n.getId());
                }
            });

            if (offeruids.size() > 0) {
                OfferExample offerExample = new OfferExample();
                offerExample.createCriteria().andIdIn(offeruids);
                Offer offer = new Offer();

                offer.setStatus(StateE.VALID.name);
                offerMapper.updateByExampleSelective(offer, offerExample);

            }

        }


    }

    public boolean needActive(Offer offer, List<PidMonitor> list) {
        if (list != null) {
            Date date = new Date();
            /* If the blocking time is less than the current time plus 15 minutes,
             * then the offer is activated,
             * because the publishers requests the interface to pull the offers according to a fixed period
             * so the offers is activated 15 minutes in advance */
            date = DateUtils.addMinutes(date, 15);
            for (PidMonitor pidMonitor : list) {
                if (offer.getTrackurl().indexOf(pidMonitor.getPid()) > 0) {
                    if (pidMonitor.getBlockst() != null && pidMonitor.getBlocket() != null) {
                        if (pidMonitor.getBlocket().before(date)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean needBlock(Offer offer, List<PidMonitor> list) {
        if (list != null) {
            Date date = new Date();


            for (PidMonitor pidMonitor : list) {
                if (offer.getTrackurl().indexOf(pidMonitor.getPid()) > 0) {
                    if (pidMonitor.getBlockst() != null && pidMonitor.getBlocket() != null) {
                        if (pidMonitor.getBlockst().before(date) && pidMonitor.getBlocket().after(date)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void offerBlockByPidChecker() {
        List<PidMonitor> pidMonitors = pidMonitorMapper.selectByExample(new PidMonitorExample());
        OfferExample example = new OfferExample();

        example.createCriteria().andStatusEqualTo(StateE.VALID.name).andTrackurlLike("%.appsflyer.%");
        List<Offer> offers = offerMapper.selectByExample(example);

        if (!CollectionUtils.isEmpty(offers)) {
            List<Integer> offeruids = Lists.newLinkedList();
            offers.forEach(n -> {
                if (needBlock(n, pidMonitors)) {
                    offeruids.add(n.getId());
                }
            });

            if (offeruids.size() > 0) {
                OfferExample offerExample = new OfferExample();
                offerExample.createCriteria().andIdIn(offeruids);
                Offer offer = new Offer();

                offer.setStatus(StateE.PIDBLOCK.name);
                System.out.println(offeruids);
                offerMapper.updateByExampleSelective(offer, offerExample);

            }

        }
    }

    public void pidBlockChecker() {
        checkAfBlock("shirley@adscanal.com", "Jason2020#", "adscanal_int");
        checkAfBlock("kevin@rainbowmobi.com", "Rain2020#", "rainbowmobi_int");
        checkAfBlock("russell@mobicoca.com", "Jason2020#", "mobicoca_int");
        checkAfBlock("frank@oceanmob.net", "Grid2020#", "oceanmob_int");
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

    public void updatePidState(String pid, String st, String et) {
        Date date = new Date();

        PidMonitor pidMonitor = new PidMonitor();
        pidMonitor.setPid(pid);
        pidMonitor.setBlocking(1);
        pidMonitor.setBlockst(DateTimeUtil.strToDateLong(st));
        pidMonitor.setBlocket(DateTimeUtil.strToDateLong(et));
        if (pidMonitor.getBlocket().before(date)) {
            pidMonitor.setBlocking(0);
        }
        PidMonitorExample example = new PidMonitorExample();
        example.createCriteria().andPidEqualTo(pid).andBlockstLessThan(DateTimeUtil.strToDateLong(st));

        pidMonitorMapper.updateByExampleSelective(pidMonitor, example);

    }

    public boolean checkAfBlock(String user, String pass, String pid) {
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
            int h = new Date().getHours();

            ReceivedDateTerm term = new ReceivedDateTerm(ComparisonTerm.GE, DateTimeUtil.getDateBefore(new Date(), 0));

            Message[] messages = folder.search(term);
            Arrays.stream(messages).forEach(msg -> {
                try {
                    if ((msg.getSubject().indexOf("Abnormal Click Volume - Traffic Blocked ") >= 0) || (msg.getSubject().indexOf("流量已全部拦截") > 0)) {
                        try {
                            String cont = msg.getContent().toString();
                            int i = cont.indexOf(" at ");
                            int offerset = 4;
                            int offerset1 = 9;
                            if (i == -1) {
                                i = cont.indexOf("将于");
                                offerset = 2;
                                offerset1 = 7;
                            }
                            String blockEnd = null;
                            if (i > 0) {
                                blockEnd = cont.substring(i + offerset, i + offerset1);
                            }
                            String st = DateTimeUtil.dateToStrLong(msg.getSentDate());
                            String et = DateTimeUtil.dateToStr(DateTimeUtil.getDateAfter(msg.getSentDate(), 1)) + " " + blockEnd + ":00";
                            updatePidState(pid, st, et);

                            System.out.println(pid);
                            System.out.println(st);
                            System.out.println(et);
                        } catch (Exception e) {
                            e.printStackTrace();
                            mailer.sendErrorMail("Pid Monitor Error: update date", e.getMessage() + "\n" + e.getLocalizedMessage());

                        }

                    }
                } catch (Exception e) {
                    mailer.sendErrorMail("Pid Monitor Error: receive pid alter", e.getMessage() + "\n" + e.getLocalizedMessage());
                    e.printStackTrace();
                }

            });

            // 关闭资源
            folder.close(false);
            store.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return result;
    }

    @PostConstruct
    @Scheduled(cron = "0 */10 * * * ?")
    public void auto() {
        pidBlockChecker();
        offerBlockByPidChecker();
        pidActiveChecker();

    }

    public static void main(String[] args) {
      /*  PidMonitorJob pidMonitorJob = new PidMonitorJob();
        pidMonitorJob.checkAfBlock("frank@oceanmob.net", "Grid2020#", "oceanmob_int");*/

        Date date = new Date();
        System.out.println(DateFormatUtils.format(date, "yyyyMMddHHmmss"));

        date = DateUtils.addMinutes(date, -20);
        System.out.println(DateFormatUtils.format(date, "yyyyMMddHHmmss"));

    }
}