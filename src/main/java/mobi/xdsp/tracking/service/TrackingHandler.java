package mobi.xdsp.tracking.service;

import com.aerospike.client.AerospikeClient;
import mobi.xdsp.tracking.dto.Click;
import mobi.xdsp.tracking.repositories.AerospikeClickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackingHandler {
    @Autowired
    private AerospikeClickRepository repository;
    @Autowired
    private AerospikeClient client;
    public void saveClick(){
        Click click = new Click();
        click.setId("testclick"+System.currentTimeMillis());
        click.setPid(1);
        click.setOid(2);
        System.out.println(click.getId());

        repository.save(click);

    }


/*
    验证参数
    验证渠道状态
    验证Affiliate状态
    检查Offer缓存
    加载Offer缓存
    验证Offer状态
    检查PublisherOffer缓存
    加载PublisherOffer缓存
    验证Publisher状态
    验证子站
    验证cap(PB)
    是否重定向
    获取重定向Offer
    拼装点击id(本地版本和传输版本)
    装载宏参数
    记录点击
    记录log
    重定向
    定时上报点击数据

    */

}
