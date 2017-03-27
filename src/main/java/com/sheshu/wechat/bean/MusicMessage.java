package com.sheshu.wechat.bean;

/**
 * 音乐消息
 */
public class MusicMessage extends BaseMessage{

    private Music Music;

    public com.sheshu.wechat.bean.Music getMusic() {
        return Music;
    }

    public void setMusic(com.sheshu.wechat.bean.Music music) {
        Music = music;
    }
}
