package com.zhancheng.applet.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhancheng.applet.service.ProductTypeService;
import com.zhancheng.constant.R;
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
 *
 * @author BianShuHeng
 * @menu
 * @email 13525382973@163.com
 * @date 2019-10-16 14:11:00
 */
@Api(tags = "产品类目")
@RestController
@RequestMapping("/ProductTypes")
public class ProductTypeController {

    @Resource
    private ProductTypeService productTypeService;

    @ApiOperation(value = "分页查询产品类目列表")
    @ApiImplicitParam(name = "pid", value = "上级id")
    @GetMapping("/list")
    public R<IPage<ProductType>> list(PageDto<ProductType> pageDto, Integer pid) {

        return R.ok(productTypeService.page(pageDto.getPage(),
                new QueryWrapper<ProductType>()
                        .eq(ObjectUtil.isNotNull(pid),"pid", pid)
                        .eq("is_deleted", 0)));
    }

    @ApiOperation(value = "查询产品类目详情")
    @ApiImplicitParam(name = "tid", value = "主键id")
    @GetMapping("/info/{tid}")
    public R<ProductType> info(@PathVariable("tid") Integer tid) {

        return R.ok(productTypeService.getById(tid));
    }

}
