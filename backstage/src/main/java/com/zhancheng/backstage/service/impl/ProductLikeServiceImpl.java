package com.zhancheng.backstage.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhancheng.backstage.service.ProductLikeService;
import com.zhancheng.dao.ProductLikeMapper;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductLike;
import org.springframework.stereotype.Service;

/**
 * 案例浏览点赞收藏
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-09-30 14:01:15
 */

@Service
public class ProductLikeServiceImpl extends ServiceImpl<ProductLikeMapper, ProductLike> implements ProductLikeService {

    @Override
    public IPage<ProductLike> queryPage(PageDto<ProductLike> pageDto, ProductLike productLike) {

        IPage<ProductLike> productLikePages = baseMapper.selectPage(pageDto.getPage(), new QueryWrapper<ProductLike>());

        return productLikePages;
    }

}