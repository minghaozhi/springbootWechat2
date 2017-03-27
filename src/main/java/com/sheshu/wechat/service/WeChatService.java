package com.sheshu.wechat.service;

import com.sheshu.wechat.bean.AccessToken;
import com.sheshu.wechat.bean.Material;
import com.sheshu.wechat.menu.Menu;

import java.io.IOException;

/**
 *
 */
public interface WeChatService {
    /**
     * 获取accessToken
     * @return
     * @throws IOException
     */
    AccessToken getAccessToken() throws IOException;

    /**
     * 上传图片
     * @return
     * @throws IOException
     */
    Material uploadMaterial() throws IOException;

}
