package com.sheshu.wechat.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheshu.constant.WeChatConfigProperties;
import com.sheshu.utils.UrlRequestUtil;
import com.sheshu.wechat.menu.Button;
import com.sheshu.wechat.menu.ClickButton;
import com.sheshu.wechat.menu.Menu;
import com.sheshu.wechat.menu.ViewButton;
import com.sheshu.wechat.service.MenuService;
import com.sheshu.wechat.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private WeChatConfigProperties weChatConfigProperties;

    @Autowired
    private WeChatService weChatService;

    @Override
    public Menu getMenu(){
        Menu menu = new Menu();
        ClickButton but11 = new ClickButton();
        but11.setName("click菜单");
        but11.setType("click");
        but11.setKey("11");

        ViewButton but21 = new ViewButton();
        but21.setName("view菜单");
        but21.setType("view");
        but21.setUrl("http://www.baidu.com");

        ClickButton but31 = new ClickButton();
        but31.setName("拍照或者相册发图");
        but31.setType("pic_photo_or_album");
        but31.setKey("31");

        ClickButton but32 = new ClickButton();
        but32.setName("地理位置");
        but32.setType("location_select");
        but32.setKey("32");

        ClickButton but41 = new ClickButton();
        but41.setName("扫码带提示");
        but41.setType("scancode_waitmsg");
        but41.setKey("41");

        ClickButton but42 = new ClickButton();
        but42.setName("扫码推事件");
        but42.setType("scancode_push");
        but42.setKey("42");

        Button button = new Button();
        button.setName("菜单1");
        Button button1=new Button();
        button1.setName("菜单2");
        Button button2=new Button();
        button2.setName("扫码");
        button.setSub_button(new Button[]{but31, but32});
        button1.setSub_button(new Button[]{but11,but21});
        button2.setSub_button(new Button[]{but41,but42});
        menu.setButton(new Button[]{button,button1,button2});
        return menu;
    }

    @Override
    public Integer createMenu() throws IOException {
        Integer errcode = 0;
        String createMenuUrl = weChatConfigProperties.getCreateMenuUrl();
        createMenuUrl = createMenuUrl.replace("ACCESS_TOKEN",this.weChatService.getAccessToken().getAccess_token());
        String result = UrlRequestUtil.sendPost(createMenuUrl, MAPPER.writeValueAsString(getMenu()));
        if(!StringUtils.isEmpty(result)){
            Map map = MAPPER.readValue(result, Map.class);
            errcode = (Integer) map.get("errcode");
        }
        return errcode;
    }

    @Override
    public String queryMenu() throws IOException {
        String queryMenuUrl = weChatConfigProperties.getQueryMenuUrl();
        queryMenuUrl = queryMenuUrl.replace("ACCESS_TOKEN", this.weChatService.getAccessToken().getAccess_token());
        String result = UrlRequestUtil.sendGet(queryMenuUrl);
        return result;
    }

    @Override
    public Integer deleteMenu() throws IOException {
        Integer errcode = 0;
        String deleteMenuUrl = weChatConfigProperties.getDeleteMenuUrl();
        deleteMenuUrl = deleteMenuUrl.replace("ACCESS_TOKEN", this.weChatService.getAccessToken().getAccess_token());
        String result = UrlRequestUtil.sendGet(deleteMenuUrl);
        if(!StringUtils.isEmpty(result)){
            Map map = MAPPER.readValue(result, Map.class);
            errcode = (Integer) map.get("errcode");
        }
        return errcode;
    }
}
