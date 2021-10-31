package mobi.xdsp.tracking.core.job;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.concurrent.atomic.LongAdder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClickCount {

    public boolean newrecord = true;

    public LongAdder success = new LongAdder();
    public long successsnp;

    public LongAdder error = new LongAdder();
    public long errorssnp;

    public LongAdder total = new LongAdder();
    public long totalsnp;

    public boolean isNewrecord() {
        return newrecord;
    }

    public void setNewrecord(boolean newrecord) {
        this.newrecord = newrecord;
    }
}
