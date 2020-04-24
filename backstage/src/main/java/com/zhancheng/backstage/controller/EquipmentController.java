package com.zhancheng.backstage.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhancheng.backstage.service.EquipmentService;
import com.zhancheng.config.security.Verify;
import com.zhancheng.constant.R;
import com.zhancheng.constant.UserIdentity;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.Equipment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @menu
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-10-10 11:33:14
 */
@Api(tags = "设备")
@RestController
@RequestMapping("/equipments")
public class EquipmentController {

    @Resource
    private EquipmentService equipmentService;

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "分页查询设备列表")
    @GetMapping("/list")
    public R<IPage<Equipment>> list(PageDto<Equipment> pageDto, Equipment equipment){

        return R.ok(equipmentService.queryPage(pageDto, equipment));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "查询设备详情")
    @ApiImplicitParam(name = "id", value = "主键id")
    @GetMapping("/info/{id}")
    public R<Equipment> info(@PathVariable("id") Integer id){

        return R.ok(equipmentService.getById(id));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "添加设备")
    @ApiImplicitParams({
                        @ApiImplicitParam(name = "number", value = "设备编号，手动填的"),
                        @ApiImplicitParam(name = "name", value = "设备名称"),
                        @ApiImplicitParam(name = "content", value = "设备介绍富文本"),
                        @ApiImplicitParam(name = "cover", value = "封面图")
            })
    @PostMapping("/save")
    public R<Boolean> save(Equipment equipment){

        return R.ok(equipmentService.save(equipment));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "修改设备")
    @ApiImplicitParams({
                        @ApiImplicitParam(name = "id", value = "主键id",required = true),
                        @ApiImplicitParam(name = "number", value = "设备编号，手动填的"),
                        @ApiImplicitParam(name = "name", value = "设备名称"),
                        @ApiImplicitParam(name = "content", value = "设备介绍富文本"),
                        @ApiImplicitParam(name = "cover", value = "封面图")
            })
    @PutMapping("/update")
    public R<Boolean> update(Equipment equipment){

        return R.ok(equipmentService.updateById(equipment));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "删除设备")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "主键id"),
    })
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestParam List<Integer> ids){

        return R.ok(equipmentService.removeByIds(ids));
    }

}
