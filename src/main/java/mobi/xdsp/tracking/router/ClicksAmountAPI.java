package mobi.xdsp.tracking.router;

import mobi.xdsp.tracking.core.job.Counter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClicksAmountAPI {


    @RequestMapping(path = "recordclks", method = {RequestMethod.POST, RequestMethod.GET})
    public Object offers(@RequestParam(value = "pid", required = true) Integer pid,
                         @RequestParam(value = "oid", required = true) Integer oid,
                         @RequestParam(value = "utchour", required = true) Integer utchour,
                         @RequestParam(value = "amount", required = true) Integer amount,
                         @RequestParam(value = "pubsub", required = true) String pubsub) {

        Counter.increaseClick(pid, oid, utchour, pubsub, 1, amount);

        return "ok";
    }

}
