package com.zhancheng.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhancheng.entity.ProductLike;
import org.springframework.stereotype.Repository;

/**
 * 案例浏览点赞收藏
 * 
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-09-30 14:01:15
 */
@Repository
public interface ProductLikeMapper extends BaseMapper<ProductLike> {

    /**
     * 统计浏览量
     * @param pid 产品id
     * @return 浏览量
     */
   Integer countProductLike(Integer pid);
}
