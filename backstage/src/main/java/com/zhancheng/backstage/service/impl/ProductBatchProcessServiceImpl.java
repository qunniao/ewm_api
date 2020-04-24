package com.zhancheng.backstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhancheng.backstage.service.ProductBatchProcessService;
import com.zhancheng.dao.ProductBatchProcessMapper;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductBatchProcess;
import org.springframework.stereotype.Service;

/**
 * 产品批次生产工艺流程
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-10-09 16:51:20
 */

@Service
public class ProductBatchProcessServiceImpl extends ServiceImpl<ProductBatchProcessMapper, ProductBatchProcess> implements ProductBatchProcessService {

    @Override
    public IPage<ProductBatchProcess> queryPage(PageDto<ProductBatchProcess> pageDto, ProductBatchProcess productBatchProcess) {

        IPage<ProductBatchProcess> productBatchProcessPages = baseMapper.selectPage(pageDto.getPage(), new QueryWrapper<ProductBatchProcess>());

        return productBatchProcessPages;
    }

}