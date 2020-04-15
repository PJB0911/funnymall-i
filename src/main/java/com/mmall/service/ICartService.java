package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.vo.CartVo;

/**
 * 购物车模块Service
 *
 * @author PJB
 * @date 2020/4/13
 */
public interface ICartService {
    /**
     * 查询用户的购物车
     *
     * @param userId 用户id
     * @return 用户的购物车
     */
    ServerResponse<CartVo> list(Integer userId);

    /**
     * 购物车中添加商品
     *
     * @param userId    用户id
     * @param productId 商品id
     * @param count     商品数量
     * @return 购物车添加商品是否成功信息
     */
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    /**
     * 更新购物车中商数量品
     *
     * @param userId    用户id
     * @param productId 商品id
     * @param count     商品数量
     * @return 购物车更新商品数量是否成功信息
     */
    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);

    /**
     * 购物车中删除商品
     *
     * @param userId     用户id
     * @param productIds 各个商品的id (用 “,” 分割 例如“1,2,3,4...”)
     * @return 购物车删除商品是否成功信息
     */
    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);

    /**
     * 购物车中商品选中或不选中
     * 根据productId是否为null，进行全（不）选或者单（不）选
     * productId==null：全选或者全不选
     * productId!=null: 选择对应商品或者不选择对应商品
     *
     * @param userId    用户id
     * @param productId 商品id （可以为null）
     * @param checked   选中或不选状态参数
     * @return 购物车操作之后的信息
     */
    ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer productId, Integer checked);

    /**
     * 查询购物车中商品的总数量
     *
     * @param userId 用户id
     * @return 购物车商品总数量
     */
    ServerResponse<Integer> getCartProductCount(Integer userId);
}




