package com.zhancheng.backstage.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductBatch;

/**
 * 产品批次
 *
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-10-09 16:51:20
 */
public interface ProductBatchService extends IService<ProductBatch> {

    /**
     * 分页查询产品批次列表
     *
     * @param pageDto      分页信息
     * @param productBatch 产品批次信息
     * @return
     */
    IPage<ProductBatch> queryPage(PageDto<ProductBatch> pageDto, ProductBatch productBatch);

    /**
     * 添加产品批次
     * @param productBatch 产品批次
     * @return Boolean
     */
    Boolean insertProductBatch(ProductBatch productBatch);
}

