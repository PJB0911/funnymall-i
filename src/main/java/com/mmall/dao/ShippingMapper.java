package com.mmall.dao;

import com.mmall.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 收货地址Mapper
 *
 * @author PJB
 * @date 2020/4/9
 */
public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增收货地址
     *
     * @param record 收货地址
     * @return 新增的行数
     */
    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    /**
     * 更新收货地址不为空的字段
     *
     * @param record 收货地址
     * @return 更新的行数
     */
    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    /**
     * 删除收货地址
     *
     * @param userId     用户id
     * @param shippingId 收货地址id
     * @return 删除的行数
     */
    int deleteByShippingIdUserId(@Param("userId") Integer userId, @Param("shippingId") Integer shippingId);

    /**
     * 更新收货地址
     *
     * @param record 收货地址
     * @return 更新的行数
     */
    int updateByShipping(Shipping record);

    /**
     * 检索收货地址
     *
     * @param userId     用户id
     * @param shippingId 地址id
     * @return 收货地址
     */
    Shipping selectByShippingIdUserId(@Param("userId") Integer userId, @Param("shippingId") Integer shippingId);

    /**
     * 检索用户的所有收货地址
     *
     * @param userId 用户id
     * @return 收货地址
     */
    List<Shipping> selectByUserId(@Param("userId") Integer userId);
}