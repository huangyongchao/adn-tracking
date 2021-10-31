package mobi.xdsp.tracking.core.job;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CounterClickDto {
    private String date;
    private Integer pid;
    private Integer oid;
    private Integer utchour;
    private Integer amount;
    private String pubsub;
    private int type;

}
