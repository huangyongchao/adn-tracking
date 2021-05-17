package mobi.xdsp.tracking.mapper;

import java.util.List;

import mobi.xdsp.tracking.entity.DailyReportAdn;
import mobi.xdsp.tracking.entity.DailyReportAdnExample;
import mobi.xdsp.tracking.entity.DailyReportAdnKey;
import org.apache.ibatis.annotations.Param;

public interface DailyReportAdnMapper {
    long countByExample(DailyReportAdnExample example);

    int deleteByExample(DailyReportAdnExample example);

    int deleteByPrimaryKey(DailyReportAdnKey key);

    int insert(DailyReportAdn record);

    int insertSelective(DailyReportAdn record);

    List<DailyReportAdn> selectByExample(DailyReportAdnExample example);

    DailyReportAdn selectByPrimaryKey(DailyReportAdnKey key);

    int updateByExampleSelective(@Param("record") DailyReportAdn record, @Param("example") DailyReportAdnExample example);

    int updateByExample(@Param("record") DailyReportAdn record, @Param("example") DailyReportAdnExample example);

    int updateByPrimaryKeySelective(DailyReportAdn record);

    int updateByPrimaryKey(DailyReportAdn record);

    int batchInsert(@Param("recordList") List<DailyReportAdn> recordList);
}