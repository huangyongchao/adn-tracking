package mobi.xdsp.tracking.core.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import mobi.xdsp.tracking.common.DateTimeUtil;
import mobi.xdsp.tracking.common.Mailer;
import mobi.xdsp.tracking.dto.enums.StateE;
import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.OfferExample;
import mobi.xdsp.tracking.entity.PidMonitor;
import mobi.xdsp.tracking.entity.PidMonitorExample;
import mobi.xdsp.tracking.mapper.OfferMapper;
import mobi.xdsp.tracking.mapper.PidMonitorMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.mail.*;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.ReceivedDateTerm;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class PidMonitorJob {
    @Autowired
    Mailer mailer;
    @Autowired
    private PidMonitorMapper pidMonitorMapper;

    @Autowired
    private OfferMapper offerMapper;


    @Scheduled(cron = "0 */3 * * * ?")
    public void pidActiveChecker() {
        Date cdate = new Date();

        OfferExample example = new OfferExample();
        List<PidMonitor> pidMonitors = pidMonitorMapper.selectByExample(new PidMonitorExample());
        pidMonitors.forEach(pidMonitor -> {
            try {

                if (pidMonitor.getBlocket() != null && pidMonitor.getBlocket().before(cdate)) {
                    // mailer.sendFrankMail("Pid Monitor Active" + pidMonitor.getPid(), pidMonitor.getPid() + DateTimeUtil.dateToStrLong(cdate));
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
            date = DateUtils.addMinutes(date, 1);
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
        checkAfBlock("frank@pubearn.com", "Jason2020#", "pubearn_int");
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

    private static final Logger logger = LoggerFactory.getLogger(PidMonitorJob.class);

    public void updatePidApps(String pid, String[] appids) {

        PidMonitorExample example = new PidMonitorExample();
        example.createCriteria().andPidEqualTo(pid);
        List<PidMonitor> pids = pidMonitorMapper.selectByExample(example);

        if (!CollectionUtils.isEmpty(pids)) {
            PidMonitor pidMonitor1 = pids.get(0);
            JSONArray jsonArray = new JSONArray();
            if (StringUtils.isNotBlank(pidMonitor1.getCookie1())) {
                jsonArray.addAll(JSONArray.parseArray(pidMonitor1.getCookie1()));
            }
            jsonArray.addAll(Arrays.stream(appids).collect(Collectors.toList()));

            Set<String> uApps = Sets.newHashSet();
            jsonArray.forEach(n -> {
                uApps.add(n.toString().trim());
            });
            Set<String> finaluApps = uApps.stream().filter(n -> StringUtils.isNotBlank(n)).collect(Collectors.toSet());

            PidMonitor pidMonitor = new PidMonitor();
            pidMonitor.setCookie1(JSONArray.toJSONString(finaluApps));
            pidMonitor.setId(pidMonitor1.getId());
            logger.warn(pidMonitor.getCookie1());
            pidMonitorMapper.updateByPrimaryKeySelective(pidMonitor);

        }

    }

    public void updatePidAppsPreBlock(String pid, String[] appids) {

        List<String> apps = Arrays.stream(appids).map(n -> n.trim()).filter(n -> StringUtils.isNotBlank(n)).collect(Collectors.toList());
        List<String> appsAppleNoid = apps.stream().filter(n -> n.startsWith("id")).map(n -> n.substring(2)).collect(Collectors.toList());
        apps.addAll(appsAppleNoid);
        OfferExample example = new OfferExample();
        example.createCriteria().andTrackurlLike("%" + pid + "%").andAppidIn(apps).andStatusEqualTo(StateE.VALID.name).andPriorityGreaterThan(new Short("2"));
        Offer offer = new Offer();
        offer.setStatus(StateE.PIDPREBLOCK.name);
        int r = offerMapper.updateByExampleSelective(offer, example);
        if(r>0){
            mailer.sendFrankMail("Pid APPs Error Pre Block:", pid + " " + r + ":\n\t\r" + JSONObject.toJSONString(apps));

        }


    }

    public void updatePidState(String pid, String st, String et, String[] appids) {
        Date date = new Date();

        PidMonitor pidMonitor = new PidMonitor();
        pidMonitor.setPid(pid);
        pidMonitor.setBlocking(1);
        pidMonitor.setBlockst(DateTimeUtil.strToDateLong(st));
        pidMonitor.setBlocket(DateTimeUtil.strToDateLong(et));
        if (pidMonitor.getBlocket().before(date)) {
            pidMonitor.setBlocking(0);
        }
        if (appids != null) {
            List<String> appsss = Arrays.stream(appids).filter(n -> StringUtils.isNotBlank(n)).map(n -> n.trim()).collect(Collectors.toList());
            pidMonitor.setCookie1(JSONObject.toJSONString(appsss));
        }

        PidMonitorExample example = new PidMonitorExample();
        example.createCriteria().andPidEqualTo(pid).andBlockstLessThan(DateTimeUtil.strToDateLong(st));
        List<PidMonitor> pids = pidMonitorMapper.selectByExample(example);


        if (!CollectionUtils.isEmpty(pids)) {
            PidMonitor pidMonitor1 = pids.get(0);
            JSONArray jsonArray = new JSONArray();
            if (StringUtils.isNotBlank(pidMonitor1.getCookie1())) {
                jsonArray.addAll(JSONArray.parseArray(pidMonitor1.getCookie1()));
            }
            jsonArray.addAll(Arrays.stream(appids).collect(Collectors.toList()));

            Set<String> uApps = Sets.newHashSet();
            jsonArray.forEach(n -> {
                uApps.add(n.toString().trim());
            });
            pidMonitor.setCookie1(JSONArray.toJSONString(uApps));
            pidMonitor.setId(pidMonitor1.getId());
            logger.warn(pidMonitor.getCookie1());
            pidMonitorMapper.updateByPrimaryKeySelective(pidMonitor);

        }

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
            int h = LocalDateTime.now(ZoneOffset.UTC).getHour();

            ReceivedDateTerm term = new ReceivedDateTerm(ComparisonTerm.GE, DateTimeUtil.getDateBefore(new Date(), 0));

            Message[] messages = folder.search(term);
            Arrays.stream(messages).forEach(msg -> {
                try {

                    if ((msg.getSubject().indexOf("Urgent Action Required") >= 0) || (msg.getSubject().indexOf("点击流量异常") > 0)) {
                        try {
                            String cont = msg.getContent().toString();


                            int apps = cont.indexOf("Apps:");
                            int sites = cont.indexOf("Sites:");
                            if (sites < 0) {
                                sites = cont.indexOf("Site");
                            }
                            String[] appids = null;
                            if (apps > 0 && sites > 0) {
                                String appstr = cont.substring(apps + 5, sites);

                                appids = appstr.split("[\\t\\n\\r]");

                        /*        try {

                                    mailer.sendFrankMail("Pid APPs Error:", pid + ":\n\t\r" + JSONObject.toJSONString(appids));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }*/
                                updatePidAppsPreBlock(pid, appids);
                            } else {
                                mailer.sendFrankMail("Pid APPs Error: Cant get apps", pid + ":\n\t\r" + cont);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            mailer.sendFrankMail("Pid APP Error: Code Error", pid + ":\n\t\r" + e.getMessage() + "\n" + e.getLocalizedMessage());

                        }

                    }


                    if ((msg.getSubject().indexOf("Abnormal Click Volume - Traffic Blocked ") >= 0) || (msg.getSubject().indexOf("流量已全部拦截") > 0)) {
                        try {
                            String cont = msg.getContent().toString();


                            int apps = cont.indexOf("Apps:");
                            int sites = cont.indexOf("Sites:");
                            if (sites < 0) {
                                sites = cont.indexOf("Site");
                            }
                            String[] appids = null;
                            if (apps > 0 && sites > 0) {
                                String appstr = cont.substring(apps + 5, sites);
                                appids = appstr.split("[\\t\\n\\r]");
                                System.out.println(JSONObject.toJSONString(appids));
                                updatePidApps(pid, appids);
                            }
                            int i = cont.indexOf(" at ");
                            int offerset = 4;
                            int offerset1 = 9;
                            if (i == -1) {
                                i = cont.indexOf("将于");
                                offerset = 2;
                                offerset1 = 7;
                            }
                            String blockEnd = null;
                            int dayoffet = 0;
                            if (i > 0) {
                                blockEnd = cont.substring(i + offerset, i + offerset1);
                            }
                            int blockh = Integer.parseInt(blockEnd.split(":")[0]);
                            if (h > blockh) {
                                dayoffet = 1;
                            }
                            String st = DateTimeUtil.dateToStrLong(msg.getSentDate());
                            String et = DateTimeUtil.dateToStr(DateTimeUtil.getDateAfter(msg.getSentDate(), dayoffet)) + " " + blockEnd + ":00";
                            updatePidState(pid, st, et, appids);

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

    @Scheduled(cron = "0 */5 * * * ?")
    public void auto() {
        pidBlockChecker();
        offerBlockByPidChecker();
    }

    public static void main(String[] args) {
      /*  PidMonitorJob pidMonitorJob = new PidMonitorJob();
        pidMonitorJob.checkAfBlock("frank@oceanmob.net", "Grid2020#", "oceanmob_int");*/

        Date date = new Date();
        System.out.println(DateFormatUtils.format(date, "yyyyMMddHHmmss"));

        date = DateUtils.addMinutes(date, -20);
        System.out.println(DateFormatUtils.format(date, "yyyyMMddHHmmss"));


        String cont = " Apps:\n" +
                "        cn.com.vau\n" +
                "                id1166619854\n" +
                "        com.myntra.android\n" +
                "        com.rapido.passenger\n" +
                "        com.nordvpn.android\n" +
                "        com.ss.android.ugc.trill\n" +
                "        com.compass.rewards\n" +
                "        Sites:";


        int apps = cont.indexOf("Apps:");
        int sites = cont.indexOf("Sites:");

        String[] appids = null;
        if (apps > 0 && sites > 0) {
            String appstr = cont.substring(apps + 5, sites);
            appids = appstr.split("[\\t\\n\\r]");
            System.out.println(JSONObject.toJSONString(Arrays.stream(appids).filter(n -> StringUtils.isNotBlank(n)).map(n -> n.trim()).collect(Collectors.toList())));
        }


        JSONArray array = JSONArray.parseArray("[\"ru.bkfon\",\"com.r888.rl\",\"com.poker888.GP\",\"com.rl888sport.rl\"]");


    }
}