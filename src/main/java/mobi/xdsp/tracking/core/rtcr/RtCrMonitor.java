package mobi.xdsp.tracking.core.rtcr;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class RtCrMonitor {
    /**
     * key poKey
     */
    public static Map<String, RtCrCounter> RT_CACHE = Maps.newHashMap();
    public static Map<String, Object> RT_MONITOR_BAD = Maps.newHashMap();
    public static Map<String, Object> RT_MONITOR_GOOD = Maps.newHashMap();


    public static int increaseClicks(String poKey) {
        if (!RT_CACHE.containsKey(poKey)) {
            RT_CACHE.put(poKey, new RtCrCounter());
        }
        return RT_CACHE.get(poKey).getRtClicks().incrementAndGet();
    }


    public static int increaseConvs(String poKey) {
        if (!RT_CACHE.containsKey(poKey)) {
            RT_CACHE.put(poKey, new RtCrCounter());
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

        //设置缓存
    }


    public static boolean checkGood(String poKey) {
        if (StringUtils.isBlank(poKey)) {
            return false;
        }
        if (RT_MONITOR_BAD.keySet().contains(poKey)) {
            return false;
        }
        return true;
    }

}
