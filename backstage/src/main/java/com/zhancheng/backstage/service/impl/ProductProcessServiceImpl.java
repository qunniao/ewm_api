package com.zhancheng.backstage.service.impl;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhancheng.backstage.service.ProductProcessService;
import com.zhancheng.dao.ProductProcessMapper;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductProcess;
import com.zhancheng.util.FileUtils;
import com.zhancheng.vo.ProductProcessListVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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