package mobi.xdsp.tracking.router;

import mobi.xdsp.tracking.core.job.Counter;
import mobi.xdsp.tracking.core.job.CounterClickDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClicksAmountAPI {


    @RequestMapping(path = "recordclks", method = {RequestMethod.POST, RequestMethod.GET})
    public Object recordclks(@RequestParam(value = "pid", required = true) Integer pid,
                             @RequestParam(value = "oid", required = true) Integer oid,
                             @RequestParam(value = "utchour", required = true) Integer utchour,
                             @RequestParam(value = "amount", required = true) Integer amount,
                             @RequestParam(value = "pubsub", required = true) String pubsub) {

        Counter.increaseClick(pid, oid, utchour, pubsub, 1, amount);

        return "ok";
    }


    @RequestMapping(path = "clks", method = {RequestMethod.POST, RequestMethod.GET})
    public Object clksdto(@RequestBody CounterClickDto clickDto) {
        Counter.increaseClick(clickDto.getPid(), clickDto.getOid(), clickDto.getUtchour(), clickDto.getPubsub(), 1, clickDto.getAmount());
        return "ok";
    }

}
