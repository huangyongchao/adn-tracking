package mobi.xdsp.tracking.mapper;

import java.util.List;

import mobi.xdsp.tracking.entity.PidMonitor;
import mobi.xdsp.tracking.entity.PidMonitorExample;
import org.apache.ibatis.annotations.Param;

public interface PidMonitorMapper {
    long countByExample(PidMonitorExample example);

    int deleteByExample(PidMonitorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PidMonitor record);

    int insertSelective(PidMonitor record);

    List<PidMonitor> selectByExample(PidMonitorExample example);

    PidMonitor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PidMonitor record, @Param("example") PidMonitorExample example);

    int updateByExample(@Param("record") PidMonitor record, @Param("example") PidMonitorExample example);

    int updateByPrimaryKeySelective(PidMonitor record);

    int updateByPrimaryKey(PidMonitor record);

    int batchInsert(@Param("recordList") List<PidMonitor> recordList);
}