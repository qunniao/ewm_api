package com.zhancheng.backstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhancheng.backstage.service.EmployeesService;
import com.zhancheng.dao.EmployeesMapper;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.Employees;
import org.springframework.stereotype.Service;

/**
 * 员工信息表
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-10-10 11:33:14
 */

@Service
public class EmployeesServiceImpl extends ServiceImpl<EmployeesMapper, Employees> implements EmployeesService {

    @Override
    public IPage<Employees> queryPage(PageDto<Employees> pageDto, Employees employees) {

        IPage<Employees> employeesPages = baseMapper.selectPage(pageDto.getPage(), new QueryWrapper<Employees>());

        return employeesPages;
    }

}