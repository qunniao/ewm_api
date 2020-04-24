package com.zhancheng.backstage.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhancheng.backstage.service.ProductImageService;
import com.zhancheng.config.security.Verify;
import com.zhancheng.constant.R;
import com.zhancheng.constant.UserIdentity;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductImage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 产品主图和轮播图
 * @menu
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-09-30 14:01:15
 */
@Api(tags = "产品主图和轮播图")
@RestController
@RequestMapping("/productimages")
public class ProductImageController {

    @Resource
    private ProductImageService productImageService;

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "分页查询产品主图和轮播图列表")
    @GetMapping("/list")
    public R<IPage<ProductImage>> list(PageDto<ProductImage> pageDto, ProductImage productImage){

        return R.ok(productImageService.queryPage(pageDto, productImage));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "查询产品主图和轮播图详情")
    @ApiImplicitParam(name = "bid", value = "主键id")
    @GetMapping("/info/{bid}")
    public R<ProductImage> info(@PathVariable("bid") Long bid){

        return R.ok(productImageService.getById(bid));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "添加产品主图和轮播图")
    @ApiImplicitParams({
                        @ApiImplicitParam(name = "bid", value = ""),
                        @ApiImplicitParam(name = "pid", value = "产品id"),
                        @ApiImplicitParam(name = "url", value = "图片路径"),
                        @ApiImplicitParam(name = "sort", value = "排序"),
                        @ApiImplicitParam(name = "isCover", value = "0为不是，1为主图"),
                        @ApiImplicitParam(name = "flag", value = "0表示图片，1表示视频"),
                        @ApiImplicitParam(name = "isDeleted", value = "是否删除 0:未删除; 1:删除 "),
                        @ApiImplicitParam(name = "gmtCreate", value = "创建时间"),
                        @ApiImplicitParam(name = "gmtModified", value = "修改时间"),
            })
    @PostMapping("/save")
    public R<Boolean> save(ProductImage productImage){

        return R.ok(productImageService.save(productImage));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "修改产品主图和轮播图")
    @ApiImplicitParams({
                        @ApiImplicitParam(name = "bid", value = ""),
                        @ApiImplicitParam(name = "pid", value = "产品id"),
                        @ApiImplicitParam(name = "url", value = "图片路径"),
                        @ApiImplicitParam(name = "sort", value = "排序"),
                        @ApiImplicitParam(name = "isCover", value = "0为不是，1为主图"),
                        @ApiImplicitParam(name = "flag", value = "0表示图片，1表示视频"),
                        @ApiImplicitParam(name = "isDeleted", value = "是否删除 0:未删除; 1:删除 "),
                        @ApiImplicitParam(name = "gmtCreate", value = "创建时间"),
                        @ApiImplicitParam(name = "gmtModified", value = "修改时间"),
            })
    @PutMapping("/update")
    public R<Boolean> update(ProductImage productImage){

        return R.ok(productImageService.updateById(productImage));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "删除产品主图和轮播图")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bids", value = "主键id"),
    })
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestParam List<Long> bids){

        return R.ok(productImageService.removeByIds(bids));
    }

}
