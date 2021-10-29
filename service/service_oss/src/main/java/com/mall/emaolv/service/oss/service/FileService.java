package com.mall.emaolv.service.oss.service;

import java.io.InputStream;
public interface FileService {
    /**
     * 文件上传阿里云
     * @param inputStream
     * @param module
     * @param originalFilename
     * @return
     */
    String upload(InputStream inputStream, String module, String originalFilename);
}
