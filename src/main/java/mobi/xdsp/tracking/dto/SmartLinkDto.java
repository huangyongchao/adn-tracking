package mobi.xdsp.tracking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SmartLinkDto {
    private int weight;
    private int offerid;
    private int pubid;
    private String tracklink;

}
