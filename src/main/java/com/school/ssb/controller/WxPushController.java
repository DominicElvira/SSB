package com.school.ssb.controller;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WxPushController {
    /*
     * 微信测试账号推送
     * */
    @RequestMapping("/push")
    public String push() {
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId("wx2e167ddb746cbfb8");//appid
        wxStorage.setSecret("d7e51cfdd784a969a9f4a42577f51dd7");//appsecret
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);

        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("oQU6E53SOk0h1uQyTBPobeHF-Ung")//要推送的用户openid
                .templateId("8jK_oAEv0-vRg5m00pq5_BTkv6xWVCBnIC705Kr5Ojw")//模版id
                .url("https://www.hao123.com")//点击模版消息要访问的网址
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        //        templateMessage.addData(new WxMpTemplateData("name", "value", "#FF00FF"));
        //                templateMessage.addData(new WxMpTemplateData(name2, value2, color2));

        //发起推送
        try {
            String msg = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            System.out.println("推送成功：" + msg);
            return "推送成功：" + msg;
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
        return "推送失败";

    }
}