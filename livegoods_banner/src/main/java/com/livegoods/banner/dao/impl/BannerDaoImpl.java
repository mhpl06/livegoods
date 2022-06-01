package com.livegoods.banner.dao.impl;

import com.bjsxt.livegoods.pojo.Banner;
import com.livegoods.banner.dao.BannerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Banner数据访问对象
 * 连接MongoDB，访问banner集合。实现数据的查询。
 */
@Repository
public class BannerDaoImpl implements BannerDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Banner> selectBanners(Query query) {
        List<Banner> result = mongoTemplate.find(query, Banner.class);
        return result;
    }
}
