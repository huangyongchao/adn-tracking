package mobi.xdsp.tracking.core.rtcr;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import mobi.xdsp.tracking.router.ConversionAPI;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class RtCrMonitor {

    private static final Logger logger = LoggerFactory.getLogger(RtCrMonitor.class);


    /**
     * key poKey
     */
    public static Map<String, RtCrCounter> RT_CACHE = Maps.newHashMap();
    public static Map<String, Object> RT_MONITOR_BAD = Maps.newHashMap();
    public static Map<String, Object> RT_MONITOR_GOOD = Maps.newHashMap();

    public static boolean isMonitor(RtCrCounter rtCrCounter) {
        if (rtCrCounter != null && rtCrCounter.getPid() == 1031) {
            return true;
        }
        return false;
    }

    public static int increaseClicks(String poKey, int pid, int oid) {
        RtCrCounter rtCrCounter = new RtCrCounter();
        rtCrCounter.setPid(pid);
        rtCrCounter.setOid(oid);
        rtCrCounter.setPoKey(poKey);
        if (!isMonitor(rtCrCounter)) {
            return 0;
        }

        if (!RT_CACHE.containsKey(poKey)) {


            RT_CACHE.put(poKey, rtCrCounter);
        }
        return RT_CACHE.get(poKey).getRtClicks().incrementAndGet();
    }


    public static int increaseConvs(String poKey, int pid, int oid) {

        RtCrCounter rtCrCounter = new RtCrCounter();
        rtCrCounter.setPid(pid);
        rtCrCounter.setOid(oid);
        rtCrCounter.setPoKey(poKey);
        if (!isMonitor(rtCrCounter)) {
            return 0;
        }

        if (!RT_CACHE.containsKey(poKey)) {

            RT_CACHE.put(poKey, rtCrCounter);
        }
        return RT_CACHE.get(poKey).getRtConvs().incrementAndGet();
    }


    public static void exchangeNumber() {
        RT_CACHE.forEach((k, v) -> {
            v.setDiffClicks(v.getRtClicks().get() - v.getOldClicks());
            v.setOldClicks(v.getRtClicks().get());
            v.setDiffConvs(v.getRtConvs().get() - v.getOldConvs());
            v.setOldConvs(v.getRtConvs().get());
        });
    }

    public static void crCallback() {
        // 检查CR
        RT_CACHE.forEach((k, v) -> {
            if (v.getDiffClicks() > 50 && v.getDiffConvs() == 0) {
                RT_MONITOR_BAD.put(v.getPoKey(), v.getDiffClicks() + "_" + v.getDiffConvs());
            } else {
                RT_MONITOR_BAD.remove(v.getPoKey());
            }

        });
        logger.error("RTCHECK:" + JSONObject.toJSONString(RT_CACHE));
        logger.error("RTCHECK:" + JSONObject.toJSONString(RT_MONITOR_BAD));
    }


    public static boolean checkGood(String poKey, int pid, int oid) {

        RtCrCounter rtCrCounter = new RtCrCounter();
        rtCrCounter.setPid(pid);
        rtCrCounter.setOid(oid);
        rtCrCounter.setPoKey(poKey);
        if (!isMonitor(rtCrCounter)) {
            return true;
        }

        if (StringUtils.isBlank(poKey)) {
            return false;
        }
        if (RT_MONITOR_BAD.keySet().contains(poKey)) {
            return false;
        }
        return true;
    }

}
