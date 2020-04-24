package com.zhancheng.applet.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhancheng.applet.service.ProductLikeService;
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

/**
 * 案例浏览点赞收藏
 *
 * @author BianShuHeng
 * @menu
 * @email 13525382973@163.com
 * @date 2019-09-30 14:01:15
 */
@Api(tags = "产品浏览点赞收藏")
@RestController
@RequestMapping("/productLike")
public class ProductLikeController {

    @Resource
    private ProductLikeService productLikeService;

    @ApiOperation(value = "添加和取消产品收藏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pid", value = "产品id", required = true),
            @ApiImplicitParam(name = "uid", value = "用户id",required = true),
            @ApiImplicitParam(name = "isCollection", value = "是否收藏 1:收藏, 0:取消收藏")
    })
    @PostMapping("/saveOrUpdate")
    public R<Boolean> save(ProductLike productLike){
        Boolean success;
        ProductLike caseLikeOne = productLikeService.getOne(new QueryWrapper<ProductLike>()
                .eq("pid", productLike.getPid())
                .eq("uid", productLike.getUid())
                .eq("is_deleted", 0));

        if (ObjectUtil.isNull(caseLikeOne)){
            success = productLikeService.save(productLike);
        }else {
            success = productLikeService.update(new UpdateWrapper<ProductLike>()
                    .eq("pid", productLike.getPid())
                    .eq("uid", productLike.getUid())
                    .set("is_collection", productLike.getIsCollection())
            );
        }

        return R.ok(success);
    }

    @ApiOperation(value = "添加和取消产品点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pid", value = "产品id", required = true),
            @ApiImplicitParam(name = "uid", value = "用户id",required = true),
            @ApiImplicitParam(name = "isLike", value = "是否点赞 1:点赞, 0:取消点赞")
    })
    @PostMapping("/like")
    public R<Boolean> like(ProductLike productLike){
        Boolean success;
        ProductLike caseLikePo = productLikeService.getOne(new QueryWrapper<ProductLike>()
                .eq("pid", productLike.getPid())
                .eq("uid", productLike.getUid())
                .eq("is_deleted", 0));

        if (ObjectUtil.isNull(caseLikePo)){
            success = productLikeService.save(productLike);
        }else {
            success = productLikeService.update(new UpdateWrapper<ProductLike>()
                    .eq("pid", productLike.getPid())
                    .eq("uid", productLike.getUid())
                    .set("is_like", productLike.getIsLike())
            );
        }

        return R.ok(success);
    }

    @ApiOperation(value = "分页查询案例浏览点赞收藏列表")
    @GetMapping("/list")
    public R<IPage<ProductLike>> list(PageDto<ProductLike> pageDto) {

        return R.ok(productLikeService.page(pageDto.getPage()));
    }




}
