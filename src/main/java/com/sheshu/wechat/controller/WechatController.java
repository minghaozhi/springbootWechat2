package com.sheshu.wechat.controller;

import com.sheshu.utils.DataShapeConvertUtil;
import com.sheshu.wechat.bean.WeChat;
import com.sheshu.wechat.service.MessageService;
import com.sheshu.wechat.service.ValidateService;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {

    //注入微信校验的service
    @Autowired
    private ValidateService validateService;

    //微信消息回复service
    @Autowired
    private MessageService messageService;

    /**
     * 校验微信服务器信息
     * @param weChat
     * @return
     */
    @RequestMapping(value = "/checkSignature",method = RequestMethod.GET)
    @ResponseBody
    public String checkSignature(WeChat weChat){
        //对微信的信息进行校验
        String result = this.validateService.checkSignature(weChat);
        return result;
    }

    /**
     * 当普通微信用户向公众账号发消息时，微信服务器将POST消息的XML数据包到开发者填写的URL上。
     * @return
     */
    @RequestMapping(value = "/checkSignature",method = RequestMethod.POST, produces = "application/xml;charset=UTF-8")
    @ResponseBody
    public String responseMessage(HttpServletRequest request) throws IOException, DocumentException {
        Map<String, String> map = DataShapeConvertUtil.parseXml(request);
        String result = this.messageService.responseMessage(map);
        return result;
    }


}
