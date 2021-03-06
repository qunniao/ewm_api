package com.zhancheng.backstage.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhancheng.backstage.service.ProductImageService;
import com.zhancheng.dao.ProductImageMapper;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductImage;
import org.springframework.stereotype.Service;

/**
 * 产品主图和轮播图
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-09-30 14:01:15
 */

@Service
public class ProductImageServiceImpl extends ServiceImpl<ProductImageMapper, ProductImage> implements ProductImageService {

    @Override
    public IPage<ProductImage> queryPage(PageDto<ProductImage> pageDto, ProductImage productImage) {

        IPage<ProductImage> productImagePages = baseMapper.selectPage(pageDto.getPage(), new QueryWrapper<ProductImage>());

        return productImagePages;
    }

}