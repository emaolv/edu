package com.mall.emaolv.service.oss.controller.admin;

import com.mall.emaolv.common.util.R;
import com.mall.emaolv.common.util.ResultCodeEnum;
import com.mall.emaolv.service.base.handler.EduException;
import com.mall.emaolv.service.oss.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
@Api(tags="阿里文件管理")
@CrossOrigin
@RestController
@RequestMapping(value = "/admin/oss/file", method = {RequestMethod.POST}, headers = "content-type=multipart/form-data")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 文件上传
     * @param file
     * @param module
     * @return
     * @throws IOException
     */
    @ApiOperation("上传文件")
    @PostMapping(value = "upload")
    public R upload(
            @ApiParam(value = "文件", required = true)
            @RequestPart("file") MultipartFile file,

            @ApiParam(value = "模块", required = true)
            @RequestParam("module") String module) throws IOException {
       try {
           InputStream inputStream = file.getInputStream();
           String originalFilename = file.getOriginalFilename();
           String uploadUrl = fileService.upload(inputStream, module, originalFilename);
           // 返回r对象
           return R.ok().message("文件上传成功").data("url", uploadUrl);
       } catch(Exception e){
           throw new EduException(ResultCodeEnum.BAD_SQL_GRAMMAR);
       }
    }
}
