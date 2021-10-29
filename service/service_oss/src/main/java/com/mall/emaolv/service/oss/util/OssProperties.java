package com.mall.emaolv.service.oss.util;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class OssProperties {
    private String endpoint;
    private String keyid;
    private String keysecret;
    private String bucketname;
}
