package com.zhancheng.backstage.service.impl;


import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhancheng.backstage.service.ProductBatchService;
import com.zhancheng.dao.ProductBatchMapper;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductBatch;
import com.zhancheng.util.FileUtils;
import org.springframework.stereotype.Service;

/**
 * 产品批次
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-10-09 16:51:20
 */

@Service
public class ProductBatchServiceImpl extends ServiceImpl<ProductBatchMapper, ProductBatch> implements ProductBatchService {

    @Override
    public IPage<ProductBatch> queryPage(PageDto<ProductBatch> pageDto, ProductBatch productBatch) {

        IPage<ProductBatch> productBatchPages = baseMapper.selectPage(pageDto.getPage(), new QueryWrapper<ProductBatch>());

        return productBatchPages;
    }

    @Override
    public Boolean insertProductBatch(ProductBatch productBatch) {

        //添加产品批次
        productBatch.insert();
        // 批次id
        Integer id = productBatch.getId();
        // 跳转网址
        String content = "http://admin.zhanchengwlkj.com:8767/productBatch/info/" + id;
        // 生成二维码
        byte[] bytes = QrCodeUtil.generatePng(content, new QrConfig());
        //二维码地址
        String qrCode = FileUtils.addInputStream(bytes);

        //添加二维码
        productBatch.setQrCode(qrCode);

        return productBatch.updateById();
    }

}