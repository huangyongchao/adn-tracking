package mobi.xdsp.tracking.router;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImpressionAPI {

    @GetMapping("/impression")
    public Object impression(@RequestParam(value = "token", required = true) String token) {

        return null;
    }

}
