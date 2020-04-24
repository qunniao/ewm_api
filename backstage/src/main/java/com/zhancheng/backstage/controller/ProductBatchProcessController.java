package com.zhancheng.backstage.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhancheng.backstage.service.ProductBatchProcessService;
import com.zhancheng.config.security.Verify;
import com.zhancheng.constant.R;
import com.zhancheng.constant.UserIdentity;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductBatchProcess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "分页查询产品批次生产工艺流程列表")
    @GetMapping("/list")
    public R<IPage<ProductBatchProcess>> list(PageDto<ProductBatchProcess> pageDto,
                                              ProductBatchProcess productBatchProcess) {

        return R.ok(productBatchProcessService.queryPage(pageDto, productBatchProcess));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "查询产品批次生产工艺流程详情")
    @ApiImplicitParam(name = "id", value = "主键id")
    @GetMapping("/info/{id}")
    public R<ProductBatchProcess> info(@PathVariable("id") Integer id) {

        return R.ok(productBatchProcessService.getById(id));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "添加产品批次生产工艺流程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "batchId", value = "产品批次id"),
            @ApiImplicitParam(name = "processId", value = "产品工艺流程id"),
            @ApiImplicitParam(name = "operatingTime", value = "操作时间"),
            @ApiImplicitParam(name = "note", value = "说明")
    })
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody ProductBatchProcess productBatchProcess) {

        return R.ok(productBatchProcessService.save(productBatchProcess));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "修改产品批次生产工艺流程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id"),
            @ApiImplicitParam(name = "batchId", value = "产品批次id"),
            @ApiImplicitParam(name = "processId", value = "产品工艺流程id"),
            @ApiImplicitParam(name = "operatingTime", value = "操作时间"),
            @ApiImplicitParam(name = "note", value = "说明")
    })
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody ProductBatchProcess productBatchProcess) {

        return R.ok(productBatchProcessService.updateById(productBatchProcess));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "删除产品批次生产工艺流程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "主键id"),
    })
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestParam List<Integer> ids) {

        return R.ok(productBatchProcessService.removeByIds(ids));
    }

}
