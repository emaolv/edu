package com.mall.emaolv.service.edu.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.emaolv.common.util.R;
import com.mall.emaolv.service.edu.entity.Teacher;
import com.mall.emaolv.service.edu.entity.vo.TeacherQueryVo;
import com.mall.emaolv.service.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author xiaohei
 * @since 2021-10-23
 */
@CrossOrigin
@Api(tags="讲师管理")
@RestController
@RequestMapping("/admin/edu/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation("获取所有讲师信息")
    @GetMapping("getAllInfo")
    public R getAllInfo(){
        List<Teacher> list = teacherService.list();
        return R.ok().data("items", list).message("成功获取讲师列表");

    }

    @ApiOperation("新增讲师")
    @PostMapping("/save")
    public R save(@ApiParam(value = "讲师对象", required = true)
                  @RequestBody Teacher teacher){
        boolean result = teacherService.save(teacher);
        if(result){
            return R.ok().message("保存成功");
        } else {
            return R.ok().message("保存失败");
        }
    }

    @ApiOperation("逻辑删除讲师")
    @DeleteMapping("remove/{id}")
    public R remove(@PathVariable String id){
        boolean result = teacherService.removeById(id);
        if(result){
            return R.ok().message("删除成功");
        }else{
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("更新讲师")
    @PutMapping("update")
    public R updateById(@ApiParam(value = "讲师对象", required = true)
                        @RequestBody Teacher teacher){
        boolean result = teacherService.updateById(teacher);
        if(result){
            return R.ok().message("修改成功");
        } else {
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("根据id获取讲师信息")
    @GetMapping("get/{id}")
    public R getById(@ApiParam("讲师对象") @PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        if(teacher != null){
            return R.ok().data("item", teacher);
        }else{
            return R.error().message("数据不存在");
        }
    }
    @ApiOperation("分页讲师列表")
    @GetMapping("list/{page}/{limit}")
    public R listPage(@ApiParam(value = "当前页码", required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录数", required = true) @PathVariable Long limit,
                        @ApiParam("讲师列表查询对象") TeacherQueryVo teacherQueryVo){

        IPage<Teacher> pageModel = teacherService.selectPage(page, limit, teacherQueryVo);
        List<Teacher> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return  R.ok().data("total", total).data("rows", records);
    }


}
