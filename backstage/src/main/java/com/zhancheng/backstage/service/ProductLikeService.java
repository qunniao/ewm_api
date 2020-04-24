package com.zhancheng.backstage.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductLike;

/**
 * 案例浏览点赞收藏
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-09-30 14:01:15
 */
public interface ProductLikeService extends IService<ProductLike> {

    /**
     * 分页查询案例浏览点赞收藏列表
     * @param pageDto  分页信息
     * @param productLike  案例浏览点赞收藏信息
     * @return
     */
    IPage<ProductLike> queryPage(PageDto<ProductLike> pageDto, ProductLike productLike);
}

