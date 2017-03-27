package com.sheshu.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wechat")
public class WeChatConfigProperties {

    private String appId;

    private String appSecret;

    private String accessTokenUrl;

    private String uploadURL;

    private String createMenuUrl;

    private String queryMenuUrl;

    private String deleteMenuUrl;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }

    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }

    public String getUploadURL() {
        return uploadURL;
    }

    public void setUploadURL(String uploadURL) {
        this.uploadURL = uploadURL;
    }

    public String getCreateMenuUrl() {
        return createMenuUrl;
    }

    public void setCreateMenuUrl(String createMenuUrl) {
        this.createMenuUrl = createMenuUrl;
    }

    public String getQueryMenuUrl() {
        return queryMenuUrl;
    }

    public void setQueryMenuUrl(String queryMenuUrl) {
        this.queryMenuUrl = queryMenuUrl;
    }

    public String getDeleteMenuUrl() {
        return deleteMenuUrl;
    }

    public void setDeleteMenuUrl(String deleteMenuUrl) {
        this.deleteMenuUrl = deleteMenuUrl;
    }
}
