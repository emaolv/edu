package com.mall.emaolv.service.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mall.emaolv.service.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.emaolv.service.edu.entity.vo.TeacherQueryVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author xiaohei
 * @since 2021-10-23
 */
@Service
public interface TeacherService extends IService<Teacher> {
    IPage<Teacher> selectPage(Long page, Long limit, TeacherQueryVo teacherQueryVo);

    List<Map<String, Object>> selectNameList(String key);

    // 调用远程方法 增加根据讲师id删除图片的方法
    boolean removeAvatarById(String id);

}
