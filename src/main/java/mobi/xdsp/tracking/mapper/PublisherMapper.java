package mobi.xdsp.tracking.mapper;

import mobi.xdsp.tracking.entity.Publisher;
import mobi.xdsp.tracking.entity.PublisherExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublisherMapper {
    long countByExample(PublisherExample example);

    int deleteByExample(PublisherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Publisher record);

    int insertSelective(Publisher record);

    List<Publisher> selectByExample(PublisherExample example);

    Publisher selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Publisher record, @Param("example") PublisherExample example);

    int updateByExample(@Param("record") Publisher record, @Param("example") PublisherExample example);

    int updateByPrimaryKeySelective(Publisher record);

    int updateByPrimaryKey(Publisher record);

    int batchInsert(@Param("recordList") List<Publisher> recordList);
}