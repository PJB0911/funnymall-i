package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

/**
 * 商品管理模块的Service
 *
 * @author PJB
 * @date 2020/4/12
 */
public interface IProductService {
    /**
     * 新增或保存商品
     *
     * @param product 产品信息
     * @return 是否新增或更新成功信息
     */
    ServerResponse saveOrUpdateProduct(Product product);

    /**
     * 修改商品的状态
     *
     * @param productId 商品id
     * @param status    商品的状态
     * @return 是否修改商品状态成功信息
     */
    ServerResponse<String> setSaleStatus(Integer productId, Integer status);

    /**
     * 后台获取商品详情
     *
     * @param productId 商品id
     * @return 商品详情信息
     */
    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    /**
     * 后台获取商品列表
     *
     * @param pageNum  页码
     * @param pageSize 每页的数量
     * @return 商品列表
     */
    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    /**
     * 后台查询符合条件的商品
     *
     * @param productName 商品名称
     * @param productId   商品id
     * @param pageNum     页码
     * @param pageSize    每页数量
     * @return 符合条件的商品列表
     */
    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);

    /**
     * 门户获取商品详情
     *
     * @param productId 商品id
     * @return 商品详情信息
     */
    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    /**
     * 门户查询符合关键词的商品
     * @param keyword 关键词
     * @param categoryId  分类id
     * @param pageNum  页码
     * @param pageSize 每页的数量
     * @param orderBy 排序参数
     * @return 符合条件的商品列表
     */
    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);
}
