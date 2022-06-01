package com.livegoods.banner.service.impl;

import com.bjsxt.livegoods.pojo.Banner;
import com.livegoods.banner.dao.BannerDao;
import com.livegoods.banner.service.BannerService;
import com.livegoods.commons.vo.LivegoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Banner轮播图查询服务实现。
 * 微服务。微服务应用是一个高内聚的，自省性非常高的工程。
 * 一个独立的服务，应该有完整才业务链和逻辑链。 如果需要使用其他的微服务提供的服务
 * 则通过远程调用+Hystrix容灾处理实现服务的应用。
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;
    @Value("${livegoods.banner.nginx.prefix}")
    private String nginxPrefix;
    /**
     * 通过DAO数据访问对象，访问MongoDB，查询轮播图数据。
     * 查询规则： 根据创建时间的降序排列， 查询前4条数据。
     * @return
     */
    @Override
    public LivegoodsResult getBanners() {
        LivegoodsResult result = new LivegoodsResult();
        try {
            // 定义查询条件
            Query query = new Query();
            query.with(
                    PageRequest.of(0, 4,
                            Sort.by(Sort.Direction.DESC, "createTime"))
            );
            List<Banner> banners = bannerDao.selectBanners(query);

            // 成功
            result.setStatus(200);
            List<String> imgResults = new ArrayList<>();
            for(Banner banner : banners){
                imgResults.add(nginxPrefix+banner.getUrl());
            }
            result.setResults(imgResults);
        }catch (Exception e){
            e.printStackTrace();
            // 失败
            result.setStatus(500);
            result.setMsg("轮播图查询失败");
        }

        return result;
    }
}
