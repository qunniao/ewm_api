package com.zhancheng.backstage.test;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.zhancheng.dto.ProductDto;
import com.zhancheng.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;


/**
 * @author BianShuHeng
 * @decription
 * @project TestController
 * @date 2019/9/29 17:20
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("1")
    public Object qrCodeTest() {

        String content = "http://hutool.cn/";

        byte[] bytes = QrCodeUtil.generatePng(content, new QrConfig());

        String stream = FileUtils.addInputStream(bytes);

        return stream;
    }

    @PostMapping("2")
    public Object test(@RequestBody ProductDto productDto) {
        String pid = request.getParameter("productDto");
        System.err.println(pid);
        System.out.println(productDto);

        return productDto;
    }

}
