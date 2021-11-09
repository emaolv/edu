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

    /**
     * 删除存储在阿里云oss中的图片
     * @param url 文件的url 地址
     */
    void removeFile(String url);
}