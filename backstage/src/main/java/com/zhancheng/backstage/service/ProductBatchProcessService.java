package com.zhancheng.backstage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductBatchProcess;

/**
 * 产品批次生产工艺流程
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-10-09 16:51:20
 */
public interface ProductBatchProcessService extends IService<ProductBatchProcess> {

    /**
     * 分页查询产品批次生产工艺流程列表
     * @param pageDto  分页信息
     * @param productBatchProcess  产品批次生产工艺流程信息
     * @return
     */
    IPage<ProductBatchProcess> queryPage(PageDto<ProductBatchProcess> pageDto, ProductBatchProcess productBatchProcess);
}

