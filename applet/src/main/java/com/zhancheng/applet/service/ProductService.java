package com.zhancheng.applet.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhancheng.dto.PageDto;
import com.zhancheng.dto.ProductDto;
import com.zhancheng.entity.Product;
import com.zhancheng.vo.ProductListVo;
import com.zhancheng.vo.ProductVo;

/**
 * 产品spu表
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-09-30 14:01:15
 */
public interface ProductService extends IService<Product> {

    /**
     * 获取产品列表
     * @param pageDto 分页信息
     * @param status 状态
     * @param tid 分类id
     * @return
     */
    IPage<ProductListVo> getProductList(PageDto pageDto, Integer status, Integer tid);

    /**
     * 查询产品详情信息
     *
     * @param pid 产品id
     * @return ProductVo
     */
    ProductVo queryDetails(Integer pid);
    /**
     * 查询推荐产品
     * @return ProductListVo
     */
    ProductListVo queryRecommend();
}

