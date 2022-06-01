package com.livegoods.commons.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 项目的返回结果类型
 * 根据开发进度逐渐增加需要的属性。
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LivegoodsResult {
    // 响应状态编码。 200 - 成功；  500 - 失败；
    private int status;
    // 返回结果数据； Banner轮播图使用，用于保存图片地址集合。
    private Object results;
    // 提示消息； Banner轮播图使用， 用于查询错误时返回提示消息。
    private String msg;
    // 返回的数据； 热销商品使用，返回查询的热销商品集合；热门推荐使用；
    private Object data;
    // 分页返回结果，是否还有更多的数据
    private boolean hasMore;
    // 预订倒计时，时间戳。
    private long time;

    public static LivegoodsResult ok(){
        LivegoodsResult result = new LivegoodsResult();
        result.setStatus(200);
        return result;
    }

    public static LivegoodsResult ok(Object data){
        LivegoodsResult result = new LivegoodsResult();
        result.setStatus(200);
        result.setData(data);
        return result;
    }

    public static LivegoodsResult error(){
        LivegoodsResult result = new LivegoodsResult();
        result.setStatus(500);
        return result;
    }

    public static LivegoodsResult error(String msg){
        LivegoodsResult result = new LivegoodsResult();
        result.setStatus(500);
        result.setMsg(msg);
        return result;
    }
}
