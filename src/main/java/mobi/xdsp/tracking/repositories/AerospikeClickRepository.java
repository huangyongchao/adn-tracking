package mobi.xdsp.tracking.repositories;

import mobi.xdsp.tracking.dto.Click;
import org.springframework.data.repository.CrudRepository;

public interface AerospikeClickRepository extends CrudRepository<Click, Object> {
}
