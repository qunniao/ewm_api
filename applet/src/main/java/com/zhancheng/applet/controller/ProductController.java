package com.zhancheng.applet.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhancheng.applet.service.ProductService;
import com.zhancheng.config.exception.MyException;
import com.zhancheng.constant.CodeMsg;
import com.zhancheng.constant.R;
import com.zhancheng.dto.PageDto;
import com.zhancheng.dto.ProductDto;
import com.zhancheng.entity.Product;
import com.zhancheng.entity.ProductLike;
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

    @GetMapping
    @ApiOperation(value = "产品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "产品状态：0生产中，1出售中，-1已下架"),
            @ApiImplicitParam(name = "tid", value = "可以传入一级分类Id也可以传入二级分类Id")
    })
    public R<IPage<ProductListVo>> getProductList(PageDto<Product> pageDto, Integer status, Integer tid) {
        return R.ok(productService.getProductList(pageDto, status, tid));
    }

    @GetMapping("/info/{pid}")
    @ApiOperation(value = "产品详情")
    @ApiImplicitParam(name = "pid", value = "产品id", required = true)
    public R<ProductVo> getProduct(@PathVariable Integer pid) {

        return R.ok(productService.queryDetails(pid));
    }

    @GetMapping("/recommend")
    @ApiOperation(value = "查询推荐产品")
    public R<ProductListVo> queryRecommend() {

        return R.ok(productService.queryRecommend());
    }


}
