package com.jczx.bean;

import lombok.Data;

/**
 * @author 于振华
 * @create 2019-12-12 14:27
 * 用于返回给渠道统计的数据
 */
@Data
public class FollowBean {

    private String channelName;//渠道名称
    private Integer num;//人数
    private Integer channelId; // 渠道id

}
