package com.zhancheng.applet.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhancheng.applet.service.EquipmentService;
import com.zhancheng.config.security.Verify;
import com.zhancheng.constant.R;
import com.zhancheng.constant.UserIdentity;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.Equipment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @ApiOperation(value = "分页查询设备列表")
    @GetMapping("/list")
    public R<IPage<Equipment>> list(PageDto<Equipment> pageDto){

        return R.ok(equipmentService.page(pageDto.getPage()));
    }

    @ApiOperation(value = "查询设备详情")
    @ApiImplicitParam(name = "id", value = "主键id")
    @GetMapping("/info/{id}")
    public R<Equipment> info(@PathVariable("id") Integer id){

        return R.ok(equipmentService.getById(id));
    }
}
