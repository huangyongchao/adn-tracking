package mobi.xdsp.tracking.router;

import mobi.xdsp.tracking.common.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeAPI {
    @Autowired
    Mailer mailer;

    @GetMapping("/noticeerror")
    public Object error(@RequestParam(value = "token", required = true) String token
            , @RequestParam(value = "msg", required = true) String msg
            , @RequestParam(value = "code", required = true) String code
    ) {

        return token + msg + code;
    }

}
