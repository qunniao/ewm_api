package com.zhancheng.backstage.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhancheng.backstage.service.ProductImageService;
import com.zhancheng.backstage.service.ProductParamService;
import com.zhancheng.backstage.service.ProductService;
import com.zhancheng.dao.ProductImageMapper;
import com.zhancheng.dao.ProductLikeMapper;
import com.zhancheng.dao.ProductMapper;
import com.zhancheng.dto.PageDto;
import com.zhancheng.dto.ProductDto;
import com.zhancheng.entity.Product;
import com.zhancheng.entity.ProductImage;
import com.zhancheng.entity.ProductParam;
import com.zhancheng.vo.ProductListVo;
import com.zhancheng.vo.ProductVo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


/**
 * 产品spu表
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-09-30 14:01:15
 */

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Resource
    private ProductImageService productImageService;

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
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateProduct(ProductDto productDto) {
        Product product = new Product();
        BeanUtil.copyProperties(productDto, product);
        boolean update = product.updateById();
        int pid = product.getPid();

        ProductParam[] productParams = productDto.getProductParams();
        ProductImage[] productImages = productDto.getProductImage();

        productImageService.remove(new QueryWrapper<ProductImage>().eq("pid", pid));
        productParamService.remove(new QueryWrapper<ProductParam>().eq("pid", pid));

        addProductInfo(productParams, productImages, pid);
        return update;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertProduct(ProductDto productDto) {
        Product product = new Product();
        BeanUtil.copyProperties(productDto, product);
        boolean insert = product.insert();
        int pid = product.getPid();

        ProductParam[] productParams = productDto.getProductParams();
        ProductImage[] productImages = productDto.getProductImage();

        addProductInfo(productParams, productImages, pid);

        return insert;
    }

    @Override
    public ProductVo queryDetails(Integer pid) {

        ProductVo productVo = baseMapper.queryDetails(pid);
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

    private void addProductInfo(ProductParam[] productParams, ProductImage[] productImages,
                                Integer pid){

        if (ObjectUtil.isNotEmpty(productParams)){
            List<ProductParam> productParamList = Arrays.asList(productParams);
            for (ProductParam productParam : productParamList) {
                productParam.setPid(pid);
            }
            productParamService.saveBatch(productParamList);
        }
        if (ObjectUtil.isNotEmpty(productImages)){
            List<ProductImage> productImageList = Arrays.asList(productImages);

            for (ProductImage productImage : productImageList) {
                productImage.setPid(pid);
            }
            productImageService.saveBatch(productImageList);
        }
    }
}