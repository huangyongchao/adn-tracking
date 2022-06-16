package mobi.xdsp.tracking.core.rtcr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RtCrCounter {

    private int oldClicks;
    private int diffClicks;
    private AtomicInteger rtClicks = new AtomicInteger(0);
    private int oldConvs;
    private int diffConvs;

    private AtomicInteger rtConvs = new AtomicInteger(0);
    private String poKey;
    private int oid;
    private int pid;


}
