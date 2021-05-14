package mobi.xdsp.tracking.mapper;

import java.util.List;

import mobi.xdsp.tracking.entity.Activate;
import mobi.xdsp.tracking.entity.ActivateExample;
import mobi.xdsp.tracking.entity.ActivateWithBLOBs;
import org.apache.ibatis.annotations.Param;

public interface ActivateMapper {
    long countByExample(ActivateExample example);

    int deleteByExample(ActivateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActivateWithBLOBs record);

    int insertSelective(ActivateWithBLOBs record);

    List<ActivateWithBLOBs> selectByExampleWithBLOBs(ActivateExample example);

    List<Activate> selectByExample(ActivateExample example);

    ActivateWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActivateWithBLOBs record, @Param("example") ActivateExample example);

    int updateByExampleWithBLOBs(@Param("record") ActivateWithBLOBs record, @Param("example") ActivateExample example);

    int updateByExample(@Param("record") Activate record, @Param("example") ActivateExample example);

    int updateByPrimaryKeySelective(ActivateWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ActivateWithBLOBs record);

    int updateByPrimaryKey(Activate record);

    int batchInsert(@Param("recordList") List<ActivateWithBLOBs> recordList);
}