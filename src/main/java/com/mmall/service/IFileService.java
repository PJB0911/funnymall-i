package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/** 商品管理模块的文件上传Service
 * @author PJB
 * @date 2020/4/12
 */
public interface IFileService {
    /**
     * 上传文件
     * @param file 文件对象
     * @param path 上传路径
     * @return  新的文件名
     */
    String upload(MultipartFile file, String path);

}
