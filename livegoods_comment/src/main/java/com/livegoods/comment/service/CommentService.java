package com.livegoods.comment.service;

import com.livegoods.commons.vo.LivegoodsResult;

// 商品评论服务接口
public interface CommentService {
    // 新增商品评论
    LivegoodsResult fellback(String orderId, String comment);
    // 根据商品主键，查询商品评论
    LivegoodsResult findCommentByItemId(String itemId, int page, int rows);
}
