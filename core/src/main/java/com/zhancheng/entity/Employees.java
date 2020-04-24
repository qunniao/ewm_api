package com.zhancheng.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 员工信息表
 * zc_employees 实体类
 * 
 * @author BianShuHeng
 * @email 13525382973@163.com
 * @date 2019-10-10 11:33:14
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("zc_employees")
public class Employees extends Model<Employees> {

	private static final long serialVersionUID = 1L;


	/**
	 * 主键id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 用户表id
	 */
	private Integer uid;

	/**
	 * 员工编号
	 */
	private String number;

	/**
	 * 员工姓名
	 */
	private String name;

	/**
	 * 手机号码
	 */
	private String phone;

	/**
	 * 性别
	 */
	private Integer gender;

	/**
	 * 出生日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date birth;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 员工头像
	 */
	private String cover;

	/**
	 * 入职时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date inTime;

	/**
	 * 职位
	 */
	private String position;

	/**
	 * 部门
	 */
	private String department;

	/**
	 * 备注
	 */
	private String note;

	/**
	 * 工作信息，json字符串
	 */
	private String workInfo;

	/**
	 * 个人信息json字符串
	 */
	private String personalInfo;

	/**
	 * 学历信息json字符串
	 */
	private String schoolInfo;

	/**
	 * 银行卡信息json字符串
	 */
	private String bankInfo;

	/**
	 * 合同信息json字符串
	 */
	private String contractInfo;

	/**
	 * 紧急联系人json字符串
	 */
	private String emergencyContactInfo;

	/**
	 * 家庭信息json字符串
	 */
	private String familyInfo;

	/**
	 * 个人材料json字符串
	 */
	private String fileInfo;

	/**
	 * 状态，-1已离职，0兼职，1全职
	 */
	private Integer status;

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
