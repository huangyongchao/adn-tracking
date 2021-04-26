package mobi.xdsp.tracking.mapper;

import mobi.xdsp.tracking.entity.OfferConf;
import mobi.xdsp.tracking.entity.OfferConfExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OfferConfMapper {
    long countByExample(OfferConfExample example);

    int deleteByExample(OfferConfExample example);

    int deleteByPrimaryKey(Integer offerid);

    int insert(OfferConf record);

    int insertSelective(OfferConf record);

    List<OfferConf> selectByExample(OfferConfExample example);

    OfferConf selectByPrimaryKey(Integer offerid);

    int updateByExampleSelective(@Param("record") OfferConf record, @Param("example") OfferConfExample example);

    int updateByExample(@Param("record") OfferConf record, @Param("example") OfferConfExample example);

    int updateByPrimaryKeySelective(OfferConf record);

    int updateByPrimaryKey(OfferConf record);

    int batchInsert(@Param("recordList") List<OfferConf> recordList);
}