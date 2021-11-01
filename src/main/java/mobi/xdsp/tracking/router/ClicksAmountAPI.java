package mobi.xdsp.tracking.router;

import com.alibaba.fastjson.JSONObject;
import mobi.xdsp.tracking.core.job.Counter;
import mobi.xdsp.tracking.core.job.CounterClickDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Object clksdto(@RequestBody List<CounterClickDto> clickDtos) {

        if (clickDtos != null) {
            System.out.println(JSONObject.toJSONString(clickDtos));
            clickDtos.forEach(clickDto -> {

                Counter.increaseClick(clickDto.getPid(), clickDto.getOid(), clickDto.getUtchour(), clickDto.getPubsub(), 1, clickDto.getAmount());
            });
        }
        return "ok";
    }

    @RequestMapping(path = "getclks", method = {RequestMethod.POST, RequestMethod.GET})
    public Object getclks() {
        return Counter.COUNTER_HOUR_TODAY;
    }


    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(new CounterClickDto()));
    }

}
