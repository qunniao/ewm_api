package com.zhancheng.applet.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhancheng.applet.service.ProductProcessService;
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

    @ApiOperation(value = "分页查询产品生产工艺流程列表")
    @ApiImplicitParam(name = "pid", value = "产品id")
    @GetMapping("/list")
    public R<IPage<ProductProcessListVo>> list(PageDto<ProductProcess> pageDto, Integer pid) {

        return R.ok(productProcessService.queryPage(pageDto, pid));
    }

    @ApiOperation(value = "查询产品生产工艺流程详情")
    @ApiImplicitParam(name = "id", value = "主键id")
    @GetMapping("/info/{id}")
    public R<ProductProcess> info(@PathVariable("id") Integer id) {

        return R.ok(productProcessService.getById(id));
    }
}
