package com.zhancheng.backstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhancheng.backstage.service.EquipmentService;
import com.zhancheng.dao.EquipmentMapper;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.Equipment;
import org.springframework.stereotype.Service;

/**
 * 
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-10-10 11:33:14
 */

@Service
public class EquipmentServiceImpl extends ServiceImpl<EquipmentMapper, Equipment> implements EquipmentService {

    @Override
    public IPage<Equipment> queryPage(PageDto<Equipment> pageDto, Equipment equipment) {

        IPage<Equipment> equipmentPages = baseMapper.selectPage(pageDto.getPage(), new QueryWrapper<Equipment>());

        return equipmentPages;
    }

}