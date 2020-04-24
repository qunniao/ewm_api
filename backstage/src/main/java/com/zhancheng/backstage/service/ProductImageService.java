package com.zhancheng.backstage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductImage;

/**
 * 产品主图和轮播图
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-09-30 14:01:15
 */
public interface ProductImageService extends IService<ProductImage> {

    /**
     * 分页查询产品主图和轮播图列表
     * @param pageDto  分页信息
     * @param productImage  产品主图和轮播图信息
     * @return
     */
    IPage<ProductImage> queryPage(PageDto<ProductImage> pageDto, ProductImage productImage);
}

