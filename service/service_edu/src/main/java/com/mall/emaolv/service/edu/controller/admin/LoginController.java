package com.mall.emaolv.service.edu.controller.admin;

import com.mall.emaolv.common.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api(tags="用户登录管理")
@RestController
@RequestMapping("/admin/user")
public class LoginController {

    /**
     * 登录
     * @return 登录token
     */
    @ApiOperation("登录")
    @PostMapping("login")
    public R login(){
        return R.ok()
                .data("token","admin-token");
    }

    @ApiOperation("获取用户登录信息")
    @GetMapping("info")
    public R getUserInfo(){
        return R.ok()
                .data("name","磐石在线学院")
                .data("roles","admin")
                .data("introduction","I am super man")
                .data("avatar","https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
    }

    @ApiOperation("退出")
    @PostMapping("logout")
    public R logout(){
        return R.ok().data("success","成功退出");
    }

}
