package com.sheshu.wechat.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheshu.constant.WeChatConfigProperties;
import com.sheshu.utils.UrlRequestUtil;
import com.sheshu.wechat.bean.AccessToken;
import com.sheshu.wechat.bean.Material;
import com.sheshu.wechat.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 */
@Service("weChatService")
public class WeChatServiceImpl implements WeChatService{

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private WeChatConfigProperties weChatConfigProperties;

    @Override
    public AccessToken getAccessToken() throws IOException {
        String accessTokenUrl = weChatConfigProperties.getAccessTokenUrl();
        String appId = weChatConfigProperties.getAppId();
        String appSecret = weChatConfigProperties.getAppSecret();
        String url = accessTokenUrl.replace("APPID",appId).replace("APPSECRET",appSecret);
        String result = UrlRequestUtil.sendGet(url);
        AccessToken token = null;
        if(!StringUtils.isEmpty(result)){
            token = MAPPER.readValue(result, AccessToken.class);
        }
        return token;
    }

    @Override
    public Material uploadMaterial() throws IOException {

        String uploadURL = weChatConfigProperties.getUploadURL();

        AccessToken accessToken = this.getAccessToken();

        return null;
    }


}
