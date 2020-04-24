package com.zhancheng.dto;

import com.zhancheng.entity.Product;
import com.zhancheng.entity.ProductImage;
import com.zhancheng.entity.ProductParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author BianShuHeng
 * @decription
 * @project ProductDto
 * @date 2019/9/30 14:29
 */
@Data
public class ProductDto extends Product {

    private Integer test;
    private ProductParam[] productParams;
    private ProductImage[] productImage;

}
