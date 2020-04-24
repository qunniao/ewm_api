package com.zhancheng.backstage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.Equipment;

/**
 * 
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-10-10 11:33:14
 */
public interface EquipmentService extends IService<Equipment> {

    /**
     * 分页查询列表
     * @param pageDto  分页信息
     * @param equipment  信息
     * @return
     */
    IPage<Equipment> queryPage(PageDto<Equipment> pageDto, Equipment equipment);
}

