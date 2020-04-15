package com.mmall.dao;

import com.mmall.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品Mapper
 *
 * @author PJB
 * @date 2020/4/9
 */
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增商品
     * @param record 商品信息
     * @return 新增行数
     */
    int insert(Product record);

    int insertSelective(Product record);

    /**
     * 查找商品
     * @param id 商品id
     * @return 商品数据
     */
    Product selectByPrimaryKey(Integer id);

    /**
     * 更新商品不为空字段
     * @param record 更新的商品信息
     * @return 更新的行数
     */
    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);


    /**
     *  查询商品列表
     * @return 商品列表
     */
    List<Product> selectList();

    /**
     *  根据商品名称和id查询商品列表
     * @param productName 商品名称
     * @param productId 商品id
     * @return  商品列表
     */
    List<Product> selectByNameAndProductId(@Param("productName") String productName, @Param("productId") Integer productId);

    /**
     *  根据商品名称和id列表查询商品列表
     * @param productName 商品名称
     * @param categoryIdLis 商品id列表
     * @return  商品列表
     */
    List<Product> selectByNameAndCategoryIds(@Param("productName") String productName, @Param("categoryIdList") List<Integer> categoryIdLis);
}
