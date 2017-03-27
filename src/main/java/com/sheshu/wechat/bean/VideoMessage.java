package com.sheshu.wechat.bean;

/**
 * 视频消息
 */
public class VideoMessage extends BaseMessage{

    private Video Video;

    public com.sheshu.wechat.bean.Video getVideo() {
        return Video;
    }

    public void setVideo(com.sheshu.wechat.bean.Video video) {
        Video = video;
    }
}
