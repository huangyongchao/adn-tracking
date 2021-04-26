package mobi.xdsp.tracking.mapper;

import mobi.xdsp.tracking.entity.PublisherOffer;
import mobi.xdsp.tracking.entity.PublisherOfferExample;
import mobi.xdsp.tracking.entity.PublisherOfferWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublisherOfferMapper {
    long countByExample(PublisherOfferExample example);

    int deleteByExample(PublisherOfferExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PublisherOfferWithBLOBs record);

    int insertSelective(PublisherOfferWithBLOBs record);

    List<PublisherOfferWithBLOBs> selectByExampleWithBLOBs(PublisherOfferExample example);

    List<PublisherOffer> selectByExample(PublisherOfferExample example);

    PublisherOfferWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PublisherOfferWithBLOBs record, @Param("example") PublisherOfferExample example);

    int updateByExampleWithBLOBs(@Param("record") PublisherOfferWithBLOBs record, @Param("example") PublisherOfferExample example);

    int updateByExample(@Param("record") PublisherOffer record, @Param("example") PublisherOfferExample example);

    int updateByPrimaryKeySelective(PublisherOfferWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PublisherOfferWithBLOBs record);

    int updateByPrimaryKey(PublisherOffer record);

    int batchInsert(@Param("recordList") List<PublisherOfferWithBLOBs> recordList);
}