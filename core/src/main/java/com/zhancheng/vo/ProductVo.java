package com.zhancheng.vo;

import com.zhancheng.entity.Product;
import com.zhancheng.entity.ProductParam;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author BianShuHeng
 * @decription
 * @project ProductVo
 * @date 2019/10/9 11:36
 */
@Data
public class ProductVo {
    private Integer pid;
    private String productName;
    private String productIntro;
    private Integer ptId;
    private Integer superiorId;
    private String detailPc;
    private Boolean isRecommend;
    private BigDecimal price;
    private Date gmtCreate;
    private Integer store;
    private Integer status;
    private String url;
    private Integer count;
    private List<ProductParam> productParams;
}
