package com.sheshu.wechat.bean;

/**
 * 语音消息
 */
public class VoiceMessage extends BaseMessage {

    private Voice Voice;

    public com.sheshu.wechat.bean.Voice getVoice() {
        return Voice;
    }

    public void setVoice(com.sheshu.wechat.bean.Voice voice) {
        Voice = voice;
    }
}
