package com.zhancheng.applet.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhancheng.dto.PageDto;
import com.zhancheng.entity.ProductProcess;
import com.zhancheng.vo.ProductProcessListVo;

/**
 * 产品生产工艺流程
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-10-09 16:51:20
 */
public interface ProductProcessService extends IService<ProductProcess> {

    /**
     * 分页查询产品生产工艺流程列表
     * @param pageDto  分页信息
     * @param pid  产品id
     * @return 生产工艺流程列表
     */
    IPage<ProductProcessListVo> queryPage(PageDto<ProductProcess> pageDto, Integer pid);
}

