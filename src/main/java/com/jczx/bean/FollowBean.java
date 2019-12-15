package com.jczx.bean;

/**
 * @author 于振华
 * @create 2019-12-12 14:27
 * 用于返回给渠道统计的数据
 */
public class FollowBean {

    private String channelName;//渠道名称
    private Integer num;//人数
    private Integer channelId; // 渠道id

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }
}
