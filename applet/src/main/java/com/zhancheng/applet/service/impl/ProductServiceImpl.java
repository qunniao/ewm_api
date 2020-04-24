package com.zhancheng.applet.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhancheng.applet.service.ProductParamService;
import com.zhancheng.applet.service.ProductService;
import com.zhancheng.config.exception.MyException;
import com.zhancheng.constant.CodeMsg;
import com.zhancheng.dao.ProductImageMapper;
import com.zhancheng.dao.ProductLikeMapper;
import com.zhancheng.dao.ProductMapper;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.Product;
import com.zhancheng.entity.ProductImage;
import com.zhancheng.entity.ProductParam;
import com.zhancheng.vo.ProductListVo;
import com.zhancheng.vo.ProductVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 产品spu表
 *
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-09-30 14:01:15
 */

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Resource
    private ProductParamService productParamService;

    @Resource
    private ProductLikeMapper productLikeMapper;

    @Resource
    private ProductImageMapper productImageMapper;

    @Override
    public IPage<ProductListVo> getProductList(PageDto pageDto, Integer status, Integer tid) {
        IPage<ProductListVo> productList = baseMapper.getProductList(pageDto.getPage(), status, tid);

        if (ObjectUtil.isNotEmpty(productList)) {

            for (ProductListVo productListVo : productList.getRecords()) {
                Integer pid = productListVo.getPid();
                // 查询主图
                productListVo.setUrl(productImageMapper.queryCover(pid));
            }
        }

        return productList;
    }

    @Override
    public ProductVo queryDetails(Integer pid) {

        ProductVo productVo = baseMapper.queryDetails(pid);
        if (ObjectUtil.isNull(productVo)){
            throw new MyException(CodeMsg.PRODUCT_NOT_EXISTED);
        }
        // 总浏览量
        Integer count = productLikeMapper.countProductLike(pid);
        // 产品参数集合
        List<ProductParam> productParamList = productParamService.list(new QueryWrapper<ProductParam>()
                .eq("pid", pid)
                .eq("is_deleted", 0));

        productVo.setCount(count);
        productVo.setProductParams(productParamList);

        return productVo;
    }

    @Override
    public ProductListVo queryRecommend() {

        return baseMapper.queryRecommend();
    }
}