package mobi.xdsp.tracking.dto;

import java.util.concurrent.atomic.AtomicInteger;

public class PBchecker {
    private AtomicInteger dayinstall = new AtomicInteger();
    private AtomicInteger dayinstallreject = new AtomicInteger();

    public AtomicInteger getDayinstall() {
        return dayinstall;
    }

    public void setDayinstall(AtomicInteger dayinstall) {
        this.dayinstall = dayinstall;
    }

    public AtomicInteger getDayinstallreject() {
        return dayinstallreject;
    }

    public void setDayinstallreject(AtomicInteger dayinstallreject) {
        this.dayinstallreject = dayinstallreject;
    }
}
