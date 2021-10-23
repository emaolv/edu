package com.mall.emaolv.service.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mall.emaolv.service.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.emaolv.service.edu.entity.vo.TeacherQueryVo;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author xiaohei
 * @since 2021-10-23
 */
public interface TeacherService extends IService<Teacher> {
    IPage<Teacher> selectPage(Long page, Long limit, TeacherQueryVo teacherQueryVo);
}
