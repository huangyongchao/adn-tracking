package mobi.xdsp.tracking.router;

import com.alibaba.fastjson.JSONObject;
import mobi.xdsp.tracking.core.job.Counter;
import mobi.xdsp.tracking.core.job.CounterClickDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClicksAmountAPI {


    @RequestMapping(path = "clks", method = {RequestMethod.POST, RequestMethod.GET})
    public Object clksdto(@RequestBody List<CounterClickDto> clickDtos) {

        if (clickDtos != null) {
            System.out.println(JSONObject.toJSONString(clickDtos));
            clickDtos.forEach(clickDto -> {
                if (clickDto.getAmount() != null && clickDto.getAmount() > 0) {

                    Counter.increaseClick(clickDto.getPid(), clickDto.getOid(), clickDto.getUtchour(), clickDto.getPubsub(), 1, clickDto.getAmount());
                }
                if (clickDto.getErramount() != null && clickDto.getErramount() > 0) {
                    Counter.increaseClick(clickDto.getPid(), clickDto.getOid(), clickDto.getUtchour(), clickDto.getPubsub(), 2, clickDto.getErramount());

                }
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
