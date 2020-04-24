package com.zhancheng.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhancheng.entity.ProductProcess;
import com.zhancheng.vo.ProductProcessListVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品生产工艺流程
 * 
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-10-09 16:51:20
 */
@Repository
public interface ProductProcessMapper extends BaseMapper<ProductProcess> {

    /**
     * 查询产品工艺生产流程 列表
     * @param page 分页数据
     * @param pid 产品id
     * @return 工艺流程列表
     */
    IPage<ProductProcessListVo> getPage(Page page, Integer pid);
	
}
