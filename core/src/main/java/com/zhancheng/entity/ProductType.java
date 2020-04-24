package com.zhancheng.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 产品类目
 * zc_product_type 实体类
 * 
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-10-16 14:11:00
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("zc_product_type")
public class ProductType extends Model<ProductType> {

	private static final long serialVersionUID = 1L;


	/**
	 * 类目id
	 */
	@TableId(value = "tid", type = IdType.AUTO)
	private Integer tid;

	/**
	 * 类目父亲id(0表示一级类目)
	 */
	private Integer pid;

	/**
	 * 类目名称
	 */
	private String typeName;

	/**
	 * 图标地址
	 */
	private String cover;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 是否删除 0:未删除; 1:删除 
	 */
	@TableLogic
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
		return this.tid;
}
}
