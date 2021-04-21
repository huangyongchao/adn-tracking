package mobi.xdsp.tracking.mapper;

import java.util.List;

import mobi.xdsp.tracking.entity.Affiliate;
import mobi.xdsp.tracking.entity.AffiliateExample;
import mobi.xdsp.tracking.entity.AffiliateWithBLOBs;
import org.apache.ibatis.annotations.Param;

public interface AffiliateMapper {
    long countByExample(AffiliateExample example);

    int deleteByExample(AffiliateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AffiliateWithBLOBs record);

    int insertSelective(AffiliateWithBLOBs record);

    List<AffiliateWithBLOBs> selectByExampleWithBLOBs(AffiliateExample example);

    List<Affiliate> selectByExample(AffiliateExample example);

    AffiliateWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AffiliateWithBLOBs record, @Param("example") AffiliateExample example);

    int updateByExampleWithBLOBs(@Param("record") AffiliateWithBLOBs record, @Param("example") AffiliateExample example);

    int updateByExample(@Param("record") Affiliate record, @Param("example") AffiliateExample example);

    int updateByPrimaryKeySelective(AffiliateWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AffiliateWithBLOBs record);

    int updateByPrimaryKey(Affiliate record);

    int batchInsert(@Param("recordList") List<AffiliateWithBLOBs> recordList);
}