package com.mall.emaolv.service.oss.serviceImpl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.mall.emaolv.service.oss.service.FileService;
import com.mall.emaolv.service.oss.util.OssProperties;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private OssProperties ossProperties;
    @Override
    public String upload(InputStream inputStream, String module, String originalFilename) {

        String endpoint = ossProperties.getEndpoint();
        String keyid = ossProperties.getKeyid();
        String keysecret = ossProperties.getKeysecret();
        String bucketname = ossProperties.getBucketname();

        // 判断oss 实例是否存在 如果不存在则创建 如果存在则获取
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyid, keysecret);
        if(!ossClient.doesBucketExist(bucketname)){
            // 创建bucket
            ossClient.createBucket(bucketname);
            // 设置oss实例的访问权限: 公共读
            ossClient.setBucketAcl(bucketname, CannedAccessControlList.PublicRead);
        }
        // 构建日期路径 avatar/2021/10/29/文件名
        String folder = new DateTime().toString("yyyy-MM-dd");
        // 文件名：uuid.扩展名
        String fileName = UUID.randomUUID().toString();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String key = module + "/" + folder + "/" + fileName + fileExtension;
        // 文件上传到阿里云
        ossClient.putObject(bucketname, key, inputStream);
        // 关闭OSSClient
        ossClient.shutdown();
        // 返回url地址
        return "https://" + bucketname + "." + endpoint + "/" + key;
    }

    @Override
    public void removeFile(String url) {
//        读取配置信息
        String endpoint = ossProperties.getEndpoint();
        String keyid = ossProperties.getKeyid();
        String keysecret = ossProperties.getKeysecret();
        String bucketname = ossProperties.getBucketname();
//        创建OssClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyid, keysecret);
        String host = "https://"+bucketname+"."+endpoint+"/";
        String objectName = url.substring(host.length());
        // 删除文件
        ossClient.deleteObject(bucketname, objectName);
        // 关闭OSSClient
        ossClient.shutdown();
    }
}
