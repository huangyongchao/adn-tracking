package com.adscanal.sdk.mapper;

import java.util.List;

import com.adscanal.sdk.entity.Offer;
import com.adscanal.sdk.entity.OfferExample;
import com.adscanal.sdk.entity.OfferKey;
import org.apache.ibatis.annotations.Param;

public interface OfferMapper {
    long countByExample(OfferExample example);

    int deleteByExample(OfferExample example);

    int deleteByPrimaryKey(OfferKey key);

    int insert(Offer record);

    int insertSelective(Offer record);

    List<Offer> selectByExample(OfferExample example);

    Offer selectByPrimaryKey(OfferKey key);

    int updateByExampleSelective(@Param("record") Offer record, @Param("example") OfferExample example);

    int updateByExample(@Param("record") Offer record, @Param("example") OfferExample example);

    int updateByPrimaryKeySelective(Offer record);

    int updateByPrimaryKey(Offer record);

    int batchInsert(@Param("recordList") List<Offer> recordList);
}