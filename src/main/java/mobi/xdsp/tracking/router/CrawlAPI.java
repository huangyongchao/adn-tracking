package mobi.xdsp.tracking.router;

import mobi.xdsp.tracking.common.Mailer;
import mobi.xdsp.tracking.entity.PidMonitor;
import mobi.xdsp.tracking.entity.PidMonitorExample;
import mobi.xdsp.tracking.mapper.PidMonitorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CrawlAPI {
    @Autowired
    Mailer mailer;
    @Autowired
    PidMonitorMapper pidMonitorMapper;

    @RequestMapping(path = "/noticeerror", method = {RequestMethod.POST, RequestMethod.GET})
    public Object error(@RequestParam(value = "token", required = true) String token
            , @RequestParam(value = "msg", required = true) String msg
            , @RequestParam(value = "code", required = true) String code
    ) {

        return "msg:" + msg + ",code:" + code;
    }

    @RequestMapping(path = "/recorddata", method = {RequestMethod.POST, RequestMethod.GET})
    public Object error(@RequestParam(value = "token", required = true) String token
            , @RequestParam(value = "data", required = true) String data
            , @RequestParam(value = "account", required = true) String account
            , @RequestParam(value = "appid", required = true) String appid
            , @RequestParam(value = "group", required = true) String group
            , @RequestParam(value = "date", required = true) String date

    ) {

        return "date" + date + " :account" + account + " :appid" + appid + " :date" + date + " :group" + group + " : " + data;
    }

    @RequestMapping(path = "/pids", method = {RequestMethod.POST, RequestMethod.GET})
    public Object getPidConf(@RequestParam(value = "token", required = true) String token) {
        PidMonitorExample pidMonitorExample = new PidMonitorExample();
        pidMonitorExample.createCriteria().andAccountIsNotNull();
        List<PidMonitor> list = pidMonitorMapper.selectByExample(pidMonitorExample);
        if (CollectionUtils.isEmpty(list)) {
            return "";
        }
        return list;
    }


}
