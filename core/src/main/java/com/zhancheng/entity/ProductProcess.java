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
 * 产品生产工艺流程
 * zc_product_process 实体类
 * 
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-10-09 16:51:20
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("zc_product_process")
public class ProductProcess extends Model<ProductProcess> {

	private static final long serialVersionUID = 1L;


	/**
	 * 主键id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 产品id
	 */
	private Integer pid;

	/**
	 * 工艺名称
	 */
	private String name;

	/**
	 * 工艺内容
	 */
	private String content;

	/**
	 * 工艺关联的操作设备id
	 */
	private Integer equipmentId;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 生产流程图片
	 */
	private String cover;

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
		return this.id;
}
}
