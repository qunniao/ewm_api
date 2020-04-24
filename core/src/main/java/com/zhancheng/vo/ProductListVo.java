package com.zhancheng.vo;

import io.swagger.models.auth.In;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author BianShuHeng
 * @decription
 * @project ProductListVo
 * @date 2019/10/9 10:33
 */
@Data
public class ProductListVo {
    private Integer pid;
    private String productName;
    private String typeName;
    private Boolean isRecommend;
    private BigDecimal price;
    private Date gmtCreate;
    private Integer store;
    private Integer status;
    private String url;
    private Integer count;
}
