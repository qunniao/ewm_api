package com.zhancheng.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhancheng.entity.Product;
import com.zhancheng.vo.ProductListVo;
import com.zhancheng.vo.ProductVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 产品spu表 Mapper 接口
 * </p>
 *
 * @author tangchao
 * @since 2019-07-29
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 查询产品列表
     * @param page 分页数据
     * @param status 状态
     * @param tid 分类id
     * @return
     */
    IPage<ProductListVo> getProductList(Page page, @Param("status") Integer status, @Param("tid") Integer tid);

    /**
     * 查询产品详情
     * @param pid 产品id
     * @return
     */
     ProductVo queryDetails(Integer pid);

    /**
     * 查询推荐产品
     * @return ProductListVo
     */
     ProductListVo queryRecommend();

}
