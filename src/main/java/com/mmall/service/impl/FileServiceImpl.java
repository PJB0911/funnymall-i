package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 商品管理模块的文件上传Servic实现类
 *
 * @author PJB
 * @date 2020/4/12
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {
    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String upload(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename();
        //获得文件的扩展名  例如abc.jpg的jpg
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        // 生成新的文件名
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
        logger.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}", fileName, path, uploadFileName);
        // 如果上传路径不存在，生成
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path, uploadFileName); // 生成该路径下的上传文件
        try {
            //文件上传到该路径
            file.transferTo(targetFile);
            //上传到ftp服务器上
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //上传ftp后，即删除tomcat中该路径下的文件
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常", e);
            return null;
        }
        return targetFile.getName();
    }
}

