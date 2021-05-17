package mobi.xdsp.tracking.dto;

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

    public LongAdder success = new LongAdder();
    public long successsnp;

    public LongAdder error = new LongAdder();
    public long errorssnp;

    public LongAdder total = new LongAdder();
    public long totalsnp;

}
