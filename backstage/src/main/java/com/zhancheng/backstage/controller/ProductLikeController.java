package com.zhancheng.backstage.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhancheng.backstage.service.ProductLikeService;
import com.zhancheng.config.security.Verify;
import com.zhancheng.constant.R;
import com.zhancheng.constant.UserIdentity;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductLike;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 案例浏览点赞收藏
 *
 * @author BianShuHeng
 * @menu
 * @email 13525382973@163.com
 * @date 2019-09-30 14:01:15
 */
@Api(tags = "案例浏览点赞收藏")
@RestController
@RequestMapping("/productLike")
public class ProductLikeController {

    @Resource
    private ProductLikeService productLikeService;

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "分页查询案例浏览点赞收藏列表")
    @GetMapping("/list")
    public R<IPage<ProductLike>> list(PageDto<ProductLike> pageDto, ProductLike productLike) {

        return R.ok(productLikeService.queryPage(pageDto, productLike));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "查询案例浏览点赞收藏详情")
    @ApiImplicitParam(name = "id", value = "主键id")
    @GetMapping("/info/{id}")
    public R<ProductLike> info(@PathVariable("id") Long id) {

        return R.ok(productLikeService.getById(id));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "添加案例浏览点赞收藏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id"),
            @ApiImplicitParam(name = "pid", value = "产品ID"),
            @ApiImplicitParam(name = "count", value = "浏览量"),
            @ApiImplicitParam(name = "isWatch", value = "是否为浏览 0否，1是"),
            @ApiImplicitParam(name = "isLike", value = "是否为点赞 0否，1是"),
            @ApiImplicitParam(name = "isCollection", value = "是否为收藏 0否，1是")
    })
    @PostMapping("/save")
    public R<Boolean> save(ProductLike productLike) {

        return R.ok(productLikeService.save(productLike));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "修改案例浏览点赞收藏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true),
            @ApiImplicitParam(name = "uid", value = "用户id"),
            @ApiImplicitParam(name = "pid", value = "产品ID"),
            @ApiImplicitParam(name = "count", value = "浏览量"),
            @ApiImplicitParam(name = "isWatch", value = "是否为浏览 0否，1是"),
            @ApiImplicitParam(name = "isLike", value = "是否为点赞 0否，1是"),
            @ApiImplicitParam(name = "isCollection", value = "是否为收藏 0否，1是")
    })
    @PutMapping("/update")
    public R<Boolean> update(ProductLike productLike) {

        return R.ok(productLikeService.updateById(productLike));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "删除案例浏览点赞收藏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "主键id"),
    })
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestParam List<Long> ids) {

        return R.ok(productLikeService.removeByIds(ids));
    }

}
