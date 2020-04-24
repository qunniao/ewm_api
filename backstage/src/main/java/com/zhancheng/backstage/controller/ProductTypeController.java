package com.zhancheng.backstage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhancheng.backstage.service.ProductTypeService;
import com.zhancheng.config.security.Verify;
import com.zhancheng.constant.R;
import com.zhancheng.constant.UserIdentity;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 产品类目
 * @menu
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-10-16 14:11:00
 */
@Api(tags = "产品类目")
@RestController
@RequestMapping("/ProductTypes")
public class ProductTypeController {

    @Resource
    private ProductTypeService productTypeService;

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "分页查询产品类目列表")
    @ApiImplicitParam(name = "pid", value = "上级id")
    @GetMapping("/list")
    public R<IPage<ProductType>> list(PageDto<ProductType> pageDto, Integer pid){

        return R.ok(productTypeService.page(pageDto.getPage(),
                new QueryWrapper<ProductType>()
                        .eq(ObjectUtil.isNotNull(pid),"pid", pid)
                        .eq("is_deleted", 0)));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "查询产品类目详情")
    @ApiImplicitParam(name = "tid", value = "主键id")
    @GetMapping("/info/{tid}")
    public R<ProductType> info(@PathVariable("tid") Integer tid){

        return R.ok(productTypeService.getById(tid));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "添加产品类目")
    @ApiImplicitParams({
                        @ApiImplicitParam(name = "pid", value = "类目父亲id(0表示一级类目)"),
                        @ApiImplicitParam(name = "typeName", value = "类目名称",required = true),
                        @ApiImplicitParam(name = "cover", value = "图标地址"),
                        @ApiImplicitParam(name = "sort", value = "排序")
            })
    @PostMapping("/save")
    public R<Boolean> save(ProductType productType){

        return R.ok(productTypeService.save(productType));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "修改产品类目")
    @ApiImplicitParams({
                        @ApiImplicitParam(name = "tid", value = "类目id", required = true),
                        @ApiImplicitParam(name = "pid", value = "类目父亲id(0表示一级类目)"),
                        @ApiImplicitParam(name = "typeName", value = "类目名称"),
                        @ApiImplicitParam(name = "cover", value = "图标地址"),
                        @ApiImplicitParam(name = "sort", value = "排序")
            })
    @PutMapping("/update")
    public R<Boolean> update(ProductType productType){

        return R.ok(productTypeService.updateById(productType));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "删除产品类目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tids", value = "主键id"),
    })
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestParam List<Integer> tids){

        return R.ok(productTypeService.removeByIds(tids));
    }

}
