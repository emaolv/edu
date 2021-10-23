package com.mall.emaolv.service.edu.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：Xiao Hei
 * @description：创建查询对象
 * @date ：Created in 2021/10/23 22:37
 */
@Data
public class TeacherQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Integer level;
    private String joinDateBegin;
    private String joinDateEnd;
}
