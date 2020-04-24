package com.zhancheng.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 产品spu表
 * </p>
 *
 * @author tangchao
 * @since 2019-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("zc_product")
public class Product extends Model<Product> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pid", type = IdType.AUTO)
    private Integer pid;

    /**
     * 店铺id
     */
    private Integer sid;

    /**
     * 商品类型id
     */
    private Integer ptId;
    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品描述
     */
    private String productIntro;
    /**
     * 图文详情
     */
    private String detailPc;

    /**
     * 产品价格
     */
    private BigDecimal price;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 价格单位
     */
    private String priceUnit;

    /**
     * 库存
     */
    private Integer store;

    /**
     * 是否推荐
     */
    private Boolean isRecommend;

    /**
     * 产品状态：0生产中，1出售中，-1已下架
     */
    private Integer status;

    /**
     * 是否删除 0:未删除; 1:删除
     */
    @TableLogic
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    private Date gmtModified;

    @Override
    protected Serializable pkVal() {
        return this.pid;
    }

}
