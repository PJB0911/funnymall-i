package com.mmall.dao;

import com.mmall.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 购物车Mapper
 *
 * @author PJB
 * @date 2020/4/9
 */
public interface CartMapper {
    /**
     * 购物车删除商品
     *
     * @param id 购物车id
     * @return 删除行数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 购物车新增商品
     *
     * @param record 购物车信息
     * @return 新增行数
     */
    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    /**
     * 更新购物车中不为空的字段
     *
     * @param record 购物车商品信息
     * @return 更新行数
     */
    int updateByPrimaryKeySelective(Cart record);

    /**
     * 更新购物车
     *
     * @param record 购物车商品信息
     * @return 更新行数
     */
    int updateByPrimaryKey(Cart record);

    /**
     * 查询用户的商品购物车记录
     *
     * @param userId    用户id
     * @param productId 商品id
     * @return 购物车记录
     */
    Cart selectCartByUserIdProductId(@Param("userId") Integer userId, @Param("productId") Integer productId);

    /**
     * 查询用户的购物车
     *
     * @param userId 用户id
     * @return
     */
    List<Cart> selectCartByUserId(Integer userId);

    /**
     * 根据用户id检索未选中状态的商品数量
     *
     * @param userId 用户id
     * @return 选中状态的商品数量
     */
    int selectCartProductCheckedStatusByUserId(Integer userId);

    /**
     * 批量删除购物车中商品
     *
     * @param userId        用户id
     * @param productIdList 产品id的list
     * @return 删除的行数
     */
    int deleteByUserIdProductIds(@Param("userId") Integer userId, @Param("productIdList") List<String> productIdList);

    /**
     * 更新购物车商品的选中状态
     *
     * @param userId    用户id
     * @param productId 商品id
     * @param checked   选中状态参数
     * @return 更新的行数
     */
    int checkedOrUncheckedProduct(@Param("userId") Integer userId, @Param("productId") Integer productId, @Param("checked") Integer checked);

    /**
     * 查询购物车商品总数量
     * 查询购物车商品的数量
     *
     * @param userId 用户id
     * @return 商品总量
     */
    int selectCartProductCount(@Param("userId") Integer userId);


    /** 查询购物车中选中的商品
     * @param userId 用户id
     * @return  购物车中未选中的商品
     */
    List<Cart> selectCheckedCartByUserId(Integer userId);
}