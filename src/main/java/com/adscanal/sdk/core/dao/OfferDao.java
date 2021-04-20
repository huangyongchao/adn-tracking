package com.adscanal.sdk.core.dao;

import com.adscanal.sdk.dto.LiveOffer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OfferDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<LiveOffer> doBatchFetch() {
        // 1,appRank table,取每个国家安卓和iOS各排名前百的offer;offer table,取当前我们已经有的offer.
        String sql = "select o.offerId,o.affiliateId,o.trackUrl,o.payoutType,o.defaultPayout,o.currency,o.conversionCap,o.appId,o.appName,o.appStoreUrl,o.sourceAffiliateId,o.sourceOfferId,o.aId,o.offerName,o.status,o.countries,o.platform,o.minOS,o.os,o.priority,o.dailybudget,o.dailymaxclicks,o.id,o.running,o.placements,o.proxyinfo,o.isReachable,o.schedule,o.imprurl,o.whitelist,o.autosubid ,o.clickSteps from offer o where o.status='active' and o.priority > 1";
        List<LiveOffer> offers = null;
        try {
            offers = jdbcTemplate.query(sql, new RowMapper<LiveOffer>() {
                @Override
                public LiveOffer mapRow(ResultSet resultSet, int i) throws SQLException {


                    LiveOffer result = new LiveOffer();
                    result.setId(resultSet.getString(1));
                    result.setAffiliateId(resultSet.getInt(2));
                    result.setCampaignId(result.getAffiliateId() + "-"
                            + result.getId());
                    result.setTrackUrl(resultSet.getString(3));
                    result.setPayoutType(resultSet.getString(4));
                    result.setDefaultPayout(resultSet.getFloat(5));
                    // result.setCurrency(resultSet.getString(6));
                    // if (StringUtils.isEmpty(result.getCurrency()))
                    // result.setCurrency(ConfigUtil
                    // .getString("adn.default.currency"));
                    result.setConversionCap(resultSet.getInt(7));
                    result.setAppId(resultSet.getString(8));
                    result.setAppName(resultSet.getString(9));
                    // result.setAppStoreUrl(resultSet.getString(10));
                    result.setRank(88);
                    //result.setRank(resultSet.getInt(11));
                    result.setYesterdayRank(12);
                    // result.setLastWeekRank(resultSet.getInt(13));
                    // result.setRankPlatform(resultSet.getString(14));
                    // result.setRankCountry(resultSet.getString(15));
                    result.setSourceAffiliateId(resultSet.getInt(11));
                    result.setSourceOfferId(resultSet.getString(12));
                    result.setaId(resultSet.getString(13));
                    result.setName(resultSet.getString(14));
                    result.setStatus(resultSet.getString(15));
                    String countries = resultSet.getString(16);
                    String platforms = resultSet.getString(17);
                    String minOSVersion = resultSet.getString(18);
                    String os = resultSet.getString(19);
                    result.setCountry(countries);
                    result.setPlatform(platforms);
                    result.setOsName(os);
                    result.setMinOS(minOSVersion);
                    result.setPriority(resultSet.getInt(20));
                    result.setDailyBudget(resultSet.getFloat(21));
                    result.setDailyMaxClicks(resultSet.getInt(22));
                    result.setUid(resultSet.getInt(23));
                    result.setRtbRunning(resultSet.getInt(24));
                    result.setPlacements(resultSet.getString(25));
                    String pid = resultSet.getString(26);

                    result.setProxyinfo(pid);
                    result.setIsReachalbe(resultSet.getByte(27));
                    result.setSchedule(resultSet.getString(28));
                    result.setImprurl(resultSet.getString(29));
                    result.setWhitelist(resultSet.getString(30));
                    result.setAutosubid(resultSet.getInt(31));
                    result.setClickSteps(resultSet.getInt(32));
                    if (StringUtils.isNotBlank(result.getCountry())
                            && StringUtils.isNotBlank(result.getOsName())
                            && StringUtils.isNotBlank(result.getTrackUrl())) {

                    }
                    result.setCountry(result.getCountry().toLowerCase());

                    return result;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


        return offers;
    }
}
