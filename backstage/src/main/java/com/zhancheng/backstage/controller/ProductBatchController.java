package com.zhancheng.backstage.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhancheng.backstage.service.ProductBatchService;
import com.zhancheng.config.security.Verify;
import com.zhancheng.constant.R;
import com.zhancheng.constant.UserIdentity;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductBatch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "分页查询产品批次列表")
    @GetMapping("/list")
    public R<IPage<ProductBatch>> list(PageDto<ProductBatch> pageDto, ProductBatch productBatch){

        return R.ok(productBatchService.queryPage(pageDto, productBatch));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "查询产品批次详情")
    @ApiImplicitParam(name = "id", value = "主键id")
    @GetMapping("/info/{id}")
    public R<ProductBatch> info(@PathVariable("id") Integer id){

        return R.ok(productBatchService.getById(id));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "添加产品批次")
    @ApiImplicitParams({
                        @ApiImplicitParam(name = "pid", value = "产品id",required = true),
                        @ApiImplicitParam(name = "name", value = "批次名称",required = true),
                        @ApiImplicitParam(name = "number", value = "批次单号，手动填写"),
                        @ApiImplicitParam(name = "store", value = "库存"),
                        @ApiImplicitParam(name = "status", value = "状态：0正在生产，1生产完成")
            })
    @PostMapping("/save")
    public R<Boolean> save(ProductBatch productBatch){

        return R.ok(productBatchService.insertProductBatch(productBatch));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "修改产品批次")
    @ApiImplicitParams({
                        @ApiImplicitParam(name = "id", value = "主键id",required = true),
                        @ApiImplicitParam(name = "pid", value = "产品id"),
                        @ApiImplicitParam(name = "name", value = "批次名称"),
                        @ApiImplicitParam(name = "number", value = "批次单号，手动填写"),
                        @ApiImplicitParam(name = "store", value = "库存"),
                        @ApiImplicitParam(name = "status", value = "状态：0正在生产，1生产完成"),
            })
    @PutMapping("/update")
    public R<Boolean> update(ProductBatch productBatch){

        return R.ok(productBatchService.updateById(productBatch));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "删除产品批次")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "主键id",required = true),
    })
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestParam List<Integer> ids){

        return R.ok(productBatchService.removeByIds(ids));
    }

}
