package com.mmall.dao;

import com.mmall.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单Mapper
 *
 * @author PJB
 * @date 2020/4/9
 */
public interface OrderMapper {
    /**
     * 删除订单
     * @param id 订单id
     * @return  删除的行数
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 增加订单
     * @param record 订单
     * @return  增加的行数
     */
    int insert(Order record);

    int insertSelective(Order record);
    /**
     * 根据订单id查询订单
     * @param id 订单id
     * @return  订单
     */
    Order selectByPrimaryKey(Integer id);
    /**
     * 更新订单不为空的字段
     * @param record 订单
     * @return  更新的行数
     */
    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /**
     * 根据用户id和订单号查询订单
     * @param userId  用户id
     * @param orderNo 订单号
     * @return  订单
     */
    Order selectByUserIdAndOrderNo(@Param("userId")Integer userId, @Param("orderNo")Long orderNo);

    /**
     * 根据订单号查询订单
     * @param orderNo 订单号
     * @return  订单
     */
    Order selectByOrderNo(Long orderNo);
    /**
     * 根据用户id查询所有订单
     * @param userId  用户id
     * @return  订单列表（按照创建时间降序）
     */
    List<Order> selectByUserId(Integer userId);

    /**
     * 查询所有订单
     * @return  订单列表（按照创建时间降序）
     */
    List<Order> selectAllOrder();
}