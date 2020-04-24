package com.zhancheng.backstage.controller;


import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhancheng.backstage.service.ProductService;
import com.zhancheng.config.exception.MyException;
import com.zhancheng.config.security.Verify;
import com.zhancheng.constant.CodeMsg;
import com.zhancheng.constant.R;
import com.zhancheng.constant.UserIdentity;
import com.zhancheng.dto.PageDto;
import com.zhancheng.dto.ProductDto;
import com.zhancheng.entity.Product;
import com.zhancheng.vo.ProductListVo;
import com.zhancheng.vo.ProductVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 产品spu表
 * @menu
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-09-30 14:01:15
 */
@Api(tags = "产品spu表")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Resource
    private ProductService productService;

    @Verify(role = UserIdentity.ADMIN)
    @GetMapping
    @ApiOperation(value = "产品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "产品状态：0生产中，1出售中，-1已下架"),
            @ApiImplicitParam(name = "tid", value = "可以传入一级分类Id也可以传入二级分类Id")
    })
    public R<IPage<ProductListVo>> getProductList(PageDto pageDto, Integer status, Integer tid) {
        return R.ok(productService.getProductList(pageDto, status,tid));
    }

    @Verify(role = UserIdentity.ADMIN)
    @GetMapping("/info/{pid}")
    @ApiOperation(value = "产品详情")
    @ApiImplicitParam(name = "pid", value = "产品id", required = true)
    public R<ProductVo> getProduct(@PathVariable Integer pid) {

        return R.ok(productService.queryDetails(pid));
    }

    @Verify(role = UserIdentity.ADMIN)
    @DeleteMapping
    @ApiOperation(value = "删除产品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pids", value = "产品id集合", required = true)
    })
    public R<Boolean> delete(@RequestParam List<Integer> pids) {

      return R.ok(productService.removeByIds(pids));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation("修改产品")
    @PutMapping("/update")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ptId", value = "商品类型Id"),
            @ApiImplicitParam(name = "pid", value = "商品Id"),
            @ApiImplicitParam(name = "productName", value = "产品名称"),
            @ApiImplicitParam(name = "productIntro", value = "产品描述"),
            @ApiImplicitParam(name = "detailPc", value = "图文详情"),
            @ApiImplicitParam(name = "price", value = "产品价格"),
            @ApiImplicitParam(name = "marketPrice", value = "市场价"),
            @ApiImplicitParam(name = "priceUnit", value = "价格单位"),
            @ApiImplicitParam(name = "isRecommend", value = "是否推荐。0不推荐，1推荐"),
            @ApiImplicitParam(name = "store", value = "库存"),
            @ApiImplicitParam(name = "status", value = "产品状态：0生产中，1出售中，-1已下架"),
            @ApiImplicitParam(name = "productParams", value = "产品参数集合"),
            @ApiImplicitParam(name = "productImage", value = "产品图片集合")
    })
    public R<Boolean> update(@RequestBody ProductDto productDto){

        return R.ok(productService.updateProduct(productDto));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "添加产品")
    @PostMapping("/insert")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ptId", value = "商品类型Id"),
            @ApiImplicitParam(name = "sid", value = "店铺id"),
            @ApiImplicitParam(name = "productName", value = "产品名称"),
            @ApiImplicitParam(name = "productIntro", value = "产品描述"),
            @ApiImplicitParam(name = "detailPc", value = "图文详情"),
            @ApiImplicitParam(name = "price", value = "产品价格"),
            @ApiImplicitParam(name = "marketPrice", value = "市场价"),
            @ApiImplicitParam(name = "priceUnit", value = "价格单位"),
            @ApiImplicitParam(name = "isRecommend", value = "是否推荐。0不推荐，1推荐"),
            @ApiImplicitParam(name = "store", value = "库存"),
            @ApiImplicitParam(name = "status", value = "产品状态：0生产中，1出售中，-1已下架"),
            @ApiImplicitParam(name = "productParams", value = "产品参数集合"),
            @ApiImplicitParam(name = "productImage", value = "产品图片集合")
    })
    @Transactional(rollbackFor = Exception.class)
    public R<Boolean> save(@RequestBody ProductDto productDto){

        return R.ok(productService.insertProduct(productDto));
    }
}
