package mobi.xdsp.tracking.repositories;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Component
public class KVDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void save(String key, String value) {
        jdbcTemplate.execute("REPLACE INTO adtest.kvcache (`key`, val) VALUES ('" + key + "', '" + value + "')");
    }

    public String get(String key) {
        if (StringUtils.isNotBlank(key)) {

            List<Map<String, Object>> list = jdbcTemplate.queryForList("select  * from kvcache s where s.`key` ='" + key + "'");
            if (!CollectionUtils.isEmpty(list)) {
                return list.get(0).toString();
            }
        }
        return null;
    }

}
