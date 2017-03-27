package com.sheshu.wechat.bean;

/**
 * 图片消息
 */
public class ImageMessage extends BaseMessage {

    private Image Image;

    public com.sheshu.wechat.bean.Image getImage() {
        return Image;
    }

    public void setImage(com.sheshu.wechat.bean.Image image) {
        Image = image;
    }
}
