package com.adscanal.sdk;

import com.adscanal.sdk.core.dao.OfferDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SdkApplicationTests {
    @Autowired
    OfferDao offerDao;
    @Test
    void contextLoads() {
        offerDao.doBatchFetch();
    }

}
