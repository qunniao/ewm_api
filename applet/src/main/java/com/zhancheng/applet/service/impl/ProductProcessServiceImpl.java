package com.zhancheng.applet.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhancheng.applet.service.ProductProcessService;
import com.zhancheng.dao.ProductProcessMapper;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductProcess;
import com.zhancheng.vo.ProductProcessListVo;
import org.springframework.stereotype.Service;

/**
 * 产品生产工艺流程
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-10-09 16:51:20
 */

@Service
public class ProductProcessServiceImpl extends ServiceImpl<ProductProcessMapper, ProductProcess> implements ProductProcessService {

    @Override
    public IPage<ProductProcessListVo> queryPage(PageDto<ProductProcess> pageDto, Integer pid) {

        return baseMapper.getPage(pageDto.getPage(), pid);
    }



}