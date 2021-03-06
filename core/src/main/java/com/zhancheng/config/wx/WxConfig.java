package com.zhancheng.config.wx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * @author BianShuHeng
 * @decription
 * @project WxConfig
 * @date 2019/9/25 10:09
 */
@Component
public class WxConfig implements com.github.wxpay.sdk.WXPayConfig  {

    /**
     * 服务器地址
     */
    @Value("${weChat.domain}")
    private String domain;

    /**
     * 商户id
     */
    @Value("${weChat.mchId}")
    private String mchId;

    /**
     * 支付key
     */
    @Value("${weChat.key}")
    private String key;

    /**
     * appId
     */
    @Value("${weChat.appId}")
    private String appId;

    /**
     * secret
     */
    @Value("${weChat.secret}")
    private String secret;

    /**
     * 回调地址
     */
    @Value("${weChat.notifyUrl}")
    private String notifyUrl;

    /**
     * 回调地址
     */
    @Value("${weChat.tradeType}")
    private String tradeType;

    /**
     * 回调地址
     */
    @Value("${weChat.grantType}")
    private String grantType;

    @Override
    public String getAppID() {
        return appId;
    }

    @Override
    public String getMchID() {
        return mchId;
    }

    @Override
    public String getKey() {
        return key;
    }

    public String getSecret() {
        return secret;
    }

    public String getGrantType() {
        return grantType;
    }
    public String getTradeType() {
        return tradeType;
    }

    @Override
    public InputStream getCertStream() {
        return null;
    }

    /**
     * 连接超时时间
     * @return
     */
    @Override
    public int getHttpConnectTimeoutMs() {
        return 10 * 1000;
    }

    /**
     * 读取超时时间
     * @return
     */
    @Override
    public int getHttpReadTimeoutMs() {
        return 10 * 1000;
    }

    /**
     * 回调地址
     */
    public String getNotifyURL() {
        return this.domain + notifyUrl;
    }
}
