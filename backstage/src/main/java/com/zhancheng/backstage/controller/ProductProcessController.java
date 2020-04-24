package com.zhancheng.backstage.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhancheng.backstage.service.ProductProcessService;
import com.zhancheng.config.security.Verify;
import com.zhancheng.constant.R;
import com.zhancheng.constant.UserIdentity;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductProcess;
import com.zhancheng.vo.ProductProcessListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 产品生产工艺流程
 *
 * @author BianShuHeng
 * @menu
 * @email 13525382973@163.com
 * @date 2019-10-09 16:51:20
 */
@Api(tags = "产品生产工艺流程")
@RestController
@RequestMapping("/productProcess")
public class ProductProcessController {

    @Resource
    private ProductProcessService productProcessService;

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "分页查询产品生产工艺流程列表")
    @ApiImplicitParam(name = "pid", value = "产品id")
    @GetMapping("/list")
    public R<IPage<ProductProcessListVo>> list(PageDto<ProductProcess> pageDto, Integer pid) {

        return R.ok(productProcessService.queryPage(pageDto, pid));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "查询产品生产工艺流程详情")
    @ApiImplicitParam(name = "id", value = "主键id")
    @GetMapping("/info/{id}")
    public R<ProductProcess> info(@PathVariable("id") Integer id) {

        return R.ok(productProcessService.getById(id));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "添加产品生产工艺流程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pid", value = "产品id"),
            @ApiImplicitParam(name = "name", value = "工艺名称"),
            @ApiImplicitParam(name = "content", value = "工艺内容"),
            @ApiImplicitParam(name = "equipmentId", value = "工艺关联的操作设备id"),
            @ApiImplicitParam(name = "sort", value = "排序"),
            @ApiImplicitParam(name = "cover", value = "生产流程图片")
    })
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody ProductProcess productProcess) {

        return R.ok(productProcessService.save(productProcess));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "修改产品生产工艺流程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id",required = true),
            @ApiImplicitParam(name = "pid", value = "产品id"),
            @ApiImplicitParam(name = "name", value = "工艺名称"),
            @ApiImplicitParam(name = "content", value = "工艺内容"),
            @ApiImplicitParam(name = "equipmentId", value = "工艺关联的操作设备id"),
            @ApiImplicitParam(name = "sort", value = "排序"),
            @ApiImplicitParam(name = "cover", value = "生产流程图片")
    })
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody ProductProcess productProcess) {

        return R.ok(productProcessService.updateById(productProcess));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "删除产品生产工艺流程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "主键id"),
    })
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestParam List<Integer> ids) {

        return R.ok(productProcessService.removeByIds(ids));
    }

}
