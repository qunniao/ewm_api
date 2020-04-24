package com.zhancheng.applet.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhancheng.applet.service.ProductBatchProcessService;
import com.zhancheng.constant.R;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductBatchProcess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 产品批次生产工艺流程
 *
 * @author BianShuHeng
 * @menu
 * @email 13525382973@163.com
 * @date 2019-10-09 16:51:20
 */
@Api(tags = "产品批次生产工艺流程")
@RestController
@RequestMapping("/productBatchProcess")
public class ProductBatchProcessController {

    @Resource
    private ProductBatchProcessService productBatchProcessService;

    @ApiOperation(value = "分页查询产品批次生产工艺流程列表")
    @GetMapping("/list")
    public R<IPage<ProductBatchProcess>> list(PageDto<ProductBatchProcess> pageDto) {

        return R.ok(productBatchProcessService.page(pageDto.getPage()));
    }

    @ApiOperation(value = "查询产品批次生产工艺流程详情")
    @ApiImplicitParam(name = "id", value = "主键id")
    @GetMapping("/info/{id}")
    public R<ProductBatchProcess> info(@PathVariable("id") Integer id) {

        return R.ok(productBatchProcessService.getById(id));
    }

}
