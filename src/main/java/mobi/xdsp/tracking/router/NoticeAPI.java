package mobi.xdsp.tracking.router;

import mobi.xdsp.tracking.common.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class NoticeAPI {
    @Autowired
    Mailer mailer;

    @RequestMapping(path = "/noticeerror", method = {RequestMethod.POST, RequestMethod.GET})
    public Object error(@RequestParam(value = "token", required = true) String token
            , @RequestParam(value = "msg", required = true) String msg
            , @RequestParam(value = "code", required = true) String code
    ) {

        return token + msg + code;
    }

    @RequestMapping(path = "/recorddata", method = {RequestMethod.POST, RequestMethod.GET})
    public Object error(@RequestParam(value = "token", required = true) String token
            , @RequestParam(value = "data", required = true) String data) {

        return token + data;
    }

}
