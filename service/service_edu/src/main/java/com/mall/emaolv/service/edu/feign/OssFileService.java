package com.mall.emaolv.service.edu.feign;

import com.mall.emaolv.common.util.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(value="service-oss")
public interface OssFileService {

    @GetMapping(value = "/admin/oss/file/test")
    R test();
    // 删除头像
    @DeleteMapping(value = "/admin/oss/file/remove")
    R removeFile(@RequestBody String url);
}
