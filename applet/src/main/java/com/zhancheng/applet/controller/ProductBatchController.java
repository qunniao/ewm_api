package com.zhancheng.applet.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhancheng.applet.service.ProductBatchService;
import com.zhancheng.config.security.Verify;
import com.zhancheng.constant.R;
import com.zhancheng.constant.UserIdentity;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductBatch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 产品批次
 * @menu
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-10-09 16:51:20
 */
@Api(tags = "产品批次")
@RestController
@RequestMapping("/productBatch")
public class ProductBatchController {

    @Resource
    private ProductBatchService productBatchService;

    @ApiOperation(value = "分页查询产品批次列表")
    @GetMapping("/list")
    public R<IPage<ProductBatch>> list(PageDto<ProductBatch> pageDto){

        return R.ok(productBatchService.page(pageDto.getPage()));
    }

    @ApiOperation(value = "查询产品批次详情")
    @ApiImplicitParam(name = "id", value = "主键id")
    @GetMapping("/info/{id}")
    public R<ProductBatch> info(@PathVariable("id") Integer id){

        return R.ok(productBatchService.getById(id));
    }

}
