package mobi.xdsp.tracking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Indexed;

import java.io.Serializable;
@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Click implements Serializable {
    @Id
    private String id;
    private Integer publisherid;
    private Integer offerid;
    private String index;

}
