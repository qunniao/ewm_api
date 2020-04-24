package com.zhancheng.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 产品主图和轮播图
 * zc_product_image 实体类
 * 
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-09-30 14:01:15
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("zc_product_image")
public class ProductImage extends Model<ProductImage> {

	private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	@TableId(value = "bid", type = IdType.AUTO)
	private Integer bid;

	/**
	 * 产品id
	 */
	private Integer pid;

	/**
	 * 图片路径
	 */
	private String url;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 0为不是，1为主图
	 */
	private Integer isCover;

	/**
	 * 0表示图片，1表示视频
	 */
	private Integer flag;

	/**
	 * 是否删除 0:未删除; 1:删除 
	 */
	private Integer isDeleted;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	@Override
	protected Serializable pkVal() {
		return this.bid;
}
}
