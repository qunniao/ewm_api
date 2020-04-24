package com.zhancheng.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhancheng.entity.ProductImage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品主图和轮播图
 * 
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-09-30 14:01:15
 */
@Repository
public interface ProductImageMapper extends BaseMapper<ProductImage> {

    /**
     * 查询主图
     * @param pid 产品id
     * @return 图片url
     */
    String queryCover(Integer pid);

}
