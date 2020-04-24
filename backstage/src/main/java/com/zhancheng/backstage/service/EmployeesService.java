package com.zhancheng.backstage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.Employees;

/**
 * 员工信息表
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-10-10 11:33:14
 */
public interface EmployeesService extends IService<Employees> {

    /**
     * 分页查询员工信息表列表
     * @param pageDto  分页信息
     * @param employees  员工信息表信息
     * @return
     */
    IPage<Employees> queryPage(PageDto<Employees> pageDto, Employees employees);
}

