package com.zhancheng.backstage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhancheng.backstage.service.ProductParamService;
import com.zhancheng.backstage.service.ProductService;
import com.zhancheng.dao.ProductMapper;
import com.zhancheng.dao.ProductParamMapper;
import com.zhancheng.entity.Product;
import com.zhancheng.entity.ProductParam;
import org.springframework.stereotype.Service;

/**
 * @author BianShuHeng
 * @decription
 * @project ProductParamServiceImpl
 * @date 2019/10/9 9:46
 */
@Service
public class ProductParamServiceImpl extends ServiceImpl<ProductParamMapper, ProductParam> implements ProductParamService {

}
