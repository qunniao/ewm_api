package com.zhancheng.backstage.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhancheng.backstage.service.EmployeesService;
import com.zhancheng.config.security.Verify;
import com.zhancheng.constant.R;
import com.zhancheng.constant.UserIdentity;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.Employees;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工信息表
 *
 * @author BianShuHeng
 * @menu
 * @email 13525382973@163.com
 * @date 2019-10-10 11:33:14
 */
@Api(tags = "员工信息表")
@RestController
@RequestMapping("/employeess")
public class EmployeesController {

    @Resource
    private EmployeesService employeesService;

    @ApiOperation(value = "分页查询员工信息表列表")
    @GetMapping("/list")
    public R<IPage<Employees>> list(PageDto<Employees> pageDto, Employees employees) {

        return R.ok(employeesService.queryPage(pageDto, employees));
    }

    @ApiOperation(value = "查询员工信息详情")
    @ApiImplicitParam(name = "id", value = "主键id")
    @GetMapping("/info/{id}")
    public R<Employees> info(@PathVariable("id") Integer id) {

        return R.ok(employeesService.getById(id));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "添加员工信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户表id"),
            @ApiImplicitParam(name = "number", value = "员工编号"),
            @ApiImplicitParam(name = "name", value = "员工姓名"),
            @ApiImplicitParam(name = "phone", value = "手机号码"),
            @ApiImplicitParam(name = "gender", value = "性别：0为保密，1为男，2为女"),
            @ApiImplicitParam(name = "birth", value = "出生日期"),
            @ApiImplicitParam(name = "email", value = "邮箱"),
            @ApiImplicitParam(name = "inTime", value = "入职时间"),
            @ApiImplicitParam(name = "position", value = "职位"),
            @ApiImplicitParam(name = "department", value = "部门"),
            @ApiImplicitParam(name = "note", value = "备注"),
            @ApiImplicitParam(name = "workInfo", value = "工作信息，json字符串"),
            @ApiImplicitParam(name = "personalInfo", value = "个人信息json字符串"),
            @ApiImplicitParam(name = "schoolInfo", value = "学历信息json字符串"),
            @ApiImplicitParam(name = "bankInfo", value = "银行卡信息json字符串"),
            @ApiImplicitParam(name = "contractInfo", value = "合同信息json字符串"),
            @ApiImplicitParam(name = "emergencyContactInfo", value = "紧急联系人json字符串"),
            @ApiImplicitParam(name = "familyInfo", value = "家庭信息json字符串"),
            @ApiImplicitParam(name = "fileInfo", value = "个人材料json字符串"),
            @ApiImplicitParam(name = "status", value = "状态，-1已离职，0兼职，1全职")
    })
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody Employees employees) {

        return R.ok(employeesService.save(employees));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "修改员工信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true),
            @ApiImplicitParam(name = "uid", value = "用户表id"),
            @ApiImplicitParam(name = "number", value = "员工编号"),
            @ApiImplicitParam(name = "name", value = "员工姓名"),
            @ApiImplicitParam(name = "phone", value = "手机号码"),
            @ApiImplicitParam(name = "gender", value = "性别：0为保密，1为男，2为女"),
            @ApiImplicitParam(name = "birth", value = "出生日期"),
            @ApiImplicitParam(name = "email", value = "邮箱"),
            @ApiImplicitParam(name = "inTime", value = "入职时间"),
            @ApiImplicitParam(name = "position", value = "职位"),
            @ApiImplicitParam(name = "department", value = "部门"),
            @ApiImplicitParam(name = "note", value = "备注"),
            @ApiImplicitParam(name = "workInfo", value = "工作信息，json字符串"),
            @ApiImplicitParam(name = "personalInfo", value = "个人信息json字符串"),
            @ApiImplicitParam(name = "schoolInfo", value = "学历信息json字符串"),
            @ApiImplicitParam(name = "bankInfo", value = "银行卡信息json字符串"),
            @ApiImplicitParam(name = "contractInfo", value = "合同信息json字符串"),
            @ApiImplicitParam(name = "emergencyContactInfo", value = "紧急联系人json字符串"),
            @ApiImplicitParam(name = "familyInfo", value = "家庭信息json字符串"),
            @ApiImplicitParam(name = "fileInfo", value = "个人材料json字符串"),
            @ApiImplicitParam(name = "status", value = "状态，-1已离职，0兼职，1全职")
    })
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody Employees employees) {

        return R.ok(employeesService.updateById(employees));
    }

    @Verify(role = UserIdentity.ADMIN)
    @ApiOperation(value = "删除员工信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "主键id"),
    })
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestParam List<Integer> ids) {

        return R.ok(employeesService.removeByIds(ids));
    }

}
