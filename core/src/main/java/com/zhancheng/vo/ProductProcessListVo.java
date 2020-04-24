package com.zhancheng.vo;

import lombok.Data;

/**
 * @author BianShuHeng
 * @decription
 * @project ProductProcessListVo
 * @date 2019/10/10 15:55
 */
@Data
public class ProductProcessListVo {
    private Integer id;
    private Integer pid;
    private String name;
    private String content;
    private String equipmentName;
    private String cover;
    private Integer sort;
}
